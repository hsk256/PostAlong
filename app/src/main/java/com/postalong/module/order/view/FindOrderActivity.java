package com.postalong.module.order.view;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.postalong.R;
import com.postalong.base.BaseActivity;
import com.postalong.modle.bean.OrderList;
import com.postalong.module.order.presenter.FindOrderPresenter;
import com.postalong.module.order.presenter.OrderAdapter;
import com.postalong.utils.Log;
import com.postalong.utils.NetWorkUtils;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * Created by heshaokang on 2015/12/12.
 */
public class FindOrderActivity extends BaseActivity<FindOrderView,FindOrderPresenter>
        implements FindOrderView,View.OnClickListener,RecyclerArrayAdapter.OnLoadMoreListener,SwipeRefreshLayout.OnRefreshListener{

    private FindOrderPresenter findOrderPresenter;
    private static final String TAG="FindOrderActivity";
    @Bind(R.id.toolbar)
    Toolbar mToolBar;
    @Bind(R.id.lv_find_order)
    EasyRecyclerView mOrderRecyclerView;
    @Bind(R.id.tv_latest)
    TextView tv_latest;
    @Bind(R.id.tv_distance)
    TextView tv_distance;
    @Bind(R.id.tv_reward)
    TextView tv_reward;
    @Bind(R.id.tv_weight_name)
    TextView tv_weight;
    @Bind(R.id.ll_latest)
    View rl_latest;
    @Bind(R.id.ll_distance)
    View rl_distance;
    @Bind(R.id.ll_reward)
    View rl_reward;
    @Bind(R.id.ll_weight)
    View rl_weight;
    @Bind(R.id.iv_latest)
    ImageView iv_latest;
    @Bind(R.id.iv_distance)
    ImageView iv_distance;
    @Bind(R.id.iv_reward)
    ImageView iv_reward;
    @Bind(R.id.iv_weight)
    ImageView iv_weight;
    @Bind(R.id.ll_wifi)
    LinearLayout ll_wifi; //无网络界面
    @Bind(R.id.ll_none)
    LinearLayout ll_none; //no data 界面

    @Bind(R.id.ll_title)
    LinearLayout mllTitle;

    //adapter
    private OrderAdapter orderAdapter;

    /**
     * 下拉刷新和上拉加载时发送的message 的waht值
     */
    private static final int PULL_TO_REFRESH = 0x11; //刷新
    private static final int LOAD_MORE = 0x12;  //上拉加载
    private int PAGE = 1;
    private final static int PAGE_SIZE = 10;

    /**
     * 是否是上拉加载  用于判断加载的数据是否清空（刷新清空，上拉不清空）
     */
    private boolean isLoading = false;
    /**
     * 点击时 reward weight内部箭头升降序的控制
     */
    private boolean reward_toggle = false;
    private boolean weight_toggle = false;
    /**
     * 以下两个变量用于判断tab之间切换时 当reawrd和weight是从由其他tab项切换点击 箭头应为默认状态 再次点击才变换
     */
    private boolean isRewradSelect = true;
    private boolean isWeightSelect = true;

    private static final String DESC = "desc"; //降序
    private static final String ASC = "asc"; //升序
    /**
     * 四种排序类型
     */
    private static String[] TYPE_SORT = {"time", "dist", "price", "weight"};
    /**
     * 筛选页面的信息变量
     */
    private static String sendAddr;
    private static String receiveAddr;
    private String tempUpdateTime;  //请求时间
    //——————————————
    private int currentSelection = 1;//当前选择的导航下标
    private int lastSelection = 0;//上一次选择的导航下标
    private View[] mLlNavs = new View[4];//导航条数组
    private TextView[] mTvNavs = new TextView[4];//导航条里的字体 数组
    private ImageView[] mIvNavs = new ImageView[4];//导航的排序图标
    private boolean[] refreshSelectArr = new boolean[4];//用于判断上拉加载时 所要请求的数据类型
    private String sortType = "dist";
    //——————————————
    private Intent locationServiceIntent;


    @Override
    public FindOrderPresenter createPresenter() {
        findOrderPresenter = new FindOrderPresenter();
        return findOrderPresenter;
    }

    @Override
    public void init() {
        setContentView(R.layout.activity_find_order);
        //导航条监听器
        rl_latest.setOnClickListener(this);
        rl_distance.setOnClickListener(this);
        rl_reward.setOnClickListener(this);
        rl_weight.setOnClickListener(this);
        selectTabs(R.id.ll_distance);

        mOrderRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mOrderRecyclerView.setAdapter(orderAdapter = new OrderAdapter(this));
        orderAdapter.setMore(R.layout.view_moreprogress, this);
        orderAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

            }
        });

        orderAdapter.setError(R.layout.view_empty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderAdapter.resumeMore();
            }
        });

        mOrderRecyclerView.setRefreshListener(this);
        onRefresh();


        //导航栏放进数组
        mLlNavs[0] = rl_latest;
        mLlNavs[1] = rl_distance;
        mLlNavs[2] = rl_reward;
        mLlNavs[3] = rl_weight;

        mTvNavs[0] = tv_latest;
        mTvNavs[1] = tv_distance;
        mTvNavs[2] = tv_reward;
        mTvNavs[3] = tv_weight;

        mIvNavs[0] = iv_latest;
        mIvNavs[1] = iv_distance;
        mIvNavs[2] = iv_reward;
        mIvNavs[3] = iv_weight;

        refreshSelectArr[1] = !(refreshSelectArr[0] = refreshSelectArr[2] = refreshSelectArr[3] = false);

        findOrderPresenter.getOrderList();
    }

    /**
     * @param id Tab 切换时的样式控制
     */
    private void selectTabs(int id) {
        //切换tab
        lastSelection = currentSelection;
        switch (id) {
            case R.id.ll_latest:
                currentSelection = 0;
                break;
            case R.id.ll_distance:
                currentSelection = 1;
                break;
            case R.id.ll_reward:
                currentSelection = 2;
                break;
            case R.id.ll_weight:
                currentSelection = 3;
                break;
        }
        if (lastSelection != currentSelection) {
            mLlNavs[lastSelection].setBackgroundColor(getMyColor(R.color.bg_grey_F7F7F7));//背景
            mTvNavs[lastSelection].setTextColor(getMyColor(R.color.tv_value));//字体
            mLlNavs[currentSelection].setBackgroundColor(getMyColor(R.color.white));//背景
            mTvNavs[currentSelection].setTextColor(getMyColor(R.color.main_green_26a65b));//字体
            mIvNavs[lastSelection].setVisibility(View.INVISIBLE);//图片
            mIvNavs[currentSelection].setVisibility(View.VISIBLE);//图片
            refreshSelectArr[lastSelection] = false;
            refreshSelectArr[currentSelection] = true;
        }
    }


    /**
     * 获取颜色
     * @param colorRes
     * @return
     */
    private int getMyColor(int colorRes) {
        return ContextCompat.getColor(this,colorRes);
    }


    private void sendNetworkRequest(int type) {

        switch (type) {
            default:
            case PULL_TO_REFRESH:

                break;

            case LOAD_MORE:
                Log.d(TAG, "sendNetworkRequest--page:" + PAGE);
                if (!NetWorkUtils.isNetWorkUsed(FindOrderActivity.this)) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                        }
                    }, 600);
                }
                isLoading = true;

                /** 加载时判断是哪个类型的数据请求 设置数据的排序类型 reward和weight内部需要再判断箭头的方向 */
                if (refreshSelectArr[2]) {
                    if (!reward_toggle) {
//                        dto.setSortVal(DESC);
                    } else {
//                        dto.setSortVal(ASC);
                    }
                } else if (refreshSelectArr[3]) {
                    if (weight_toggle) {
//                        dto.setSortVal(DESC);
                    }
                    else {
//                        dto.setSortVal(ASC);
                    }
                } else if (refreshSelectArr[1]) {
//                    dto.setSortVal(ASC);
                } else if (refreshSelectArr[0]) {
//                    dto.setSortVal(DESC);
                }
//                findOrderPresenter.requestInformation(dto, false);
                break;
        }
    }

    /**
     * 上拉加载更多
     */
    @Override
    public void onLoadMore() {

    }

    /**
     * 下拉刷新
     */
    @Override
    public void onRefresh() {

    }




    @Override
    public void onClick(View v) {

        selectTabs(v.getId());
        PAGE = 1;
        isLoading = false;
        if (!NetWorkUtils.isNetWorkUsed(FindOrderActivity.this)) {
            new Handler().post(new Runnable() {
                @Override
                public void run() {
                    ll_wifi.setVisibility(View.VISIBLE);
                    ll_none.setVisibility(View.GONE);
                }
            });
        }
        switch (v.getId()) {
            case R.id.ll_latest:
                sortType = TYPE_SORT[0];
                isRewradSelect = true;
                isWeightSelect = true;
                break;
            case R.id.ll_distance: // 距离
                isRewradSelect = true;
                isWeightSelect = true;
                sortType = TYPE_SORT[1];
                //strategyRequestPage(false); // 如果是按照距离查找订单，则判断定位再查找订单
                return;
            case R.id.ll_reward:
                //iv_weight.setBackgroundResource(R.mipmap.icon_sort_up);
                /**先判断点击reward时 是从其他选项切换过来的 还是二次点击*/
                if (isRewradSelect) {
                    iv_reward.setImageResource(R.mipmap.icon_sort_down);
                    isRewradSelect = false;
                    reward_toggle = false;
                } else {
                    reward_toggle = !reward_toggle;
                    if (reward_toggle) {
                        iv_reward.setImageResource(R.mipmap.icon_sort_up);
                    } else {
                        iv_reward.setImageResource(R.mipmap.icon_sort_down);
                    }
                }
                sortType = TYPE_SORT[2];
                isWeightSelect = true;
                break;
            case R.id.ll_weight:
                // iv_reward.setBackgroundResource(R.mipmap.icon_sort_down);
                if (isWeightSelect) {

                    iv_weight.setImageResource(R.mipmap.icon_sort_up);
                    isWeightSelect = false;
                    weight_toggle = false;
                } else {
                    weight_toggle = !weight_toggle;
                    if (weight_toggle) {
                        iv_weight.setImageResource(R.mipmap.icon_sort_down);
                    } else {
                        iv_weight.setImageResource(R.mipmap.icon_sort_up);
                    }
                }
                sortType = TYPE_SORT[3];
                isRewradSelect = true;
                break;
        }

    }

    @Override
    public void setData(ArrayList<OrderList> data) {
        Log.d(TAG,"data--"+data);
    }
}
