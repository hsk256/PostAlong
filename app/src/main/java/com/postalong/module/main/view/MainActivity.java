package com.postalong.module.main.view;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.postalong.R;
import com.postalong.base.BaseActivity;
import com.postalong.modle.bean.DeliverInfo;
import com.postalong.modle.service.ServiceClient;
import com.postalong.module.main.presenter.MainPresenter;
import com.postalong.utils.Log;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends BaseActivity<MainView,MainPresenter> {

    private static final String TAG = "MainActivity";

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout; //侧边栏布局
    @Bind(R.id.head_photo)
    ImageView head_photo;
    @Bind(R.id.iv_ptitle)
    ImageView mIvPTitle; // 头衔图标
    @Bind(R.id.tv_user_name)
    TextView account_name;
    @Bind(R.id.tv_title)
    TextView mTvUserTitle;//用户真实姓名
    @Bind(R.id.rl_apply)
    View mRlApply;//“申请为递送人”行
    @Bind(R.id.rl_apply_line)
    View mRlApplyLine;//“递送人”行的线
    @Bind(R.id.rl_create_plan)
    View mCreatePlan;//我的行程
    @Bind(R.id.schedule_line)
    View mScheduleLine;//我的行程

    private MainPresenter mainPresenter;
    private MainFragment mainFragment;
    private MenuItem menuMsg;
    public static boolean hasNewMessage;//是否收到新消息

    @Override
    public void init() {
        setContentView(R.layout.activity_main);
        mainFragment = new MainFragment();
        mainPresenter.replaceFragment(this,mainFragment);

        mToolbar.setNavigationIcon(R.mipmap.icon_menu);
        setSupportActionBar(mToolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,mToolbar,
                R.string.drawer_open,R.string.drawer_close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

    }



    private void getGoodList() {
        Map paramsMap = new HashMap();
        paramsMap.put("page","1");
        paramsMap.put("pageSize","10");
        paramsMap.put("curJd","106.6007045");
        paramsMap.put("curWd","29.5342324");
        paramsMap.put("sortType", "dist");
        paramsMap.put("sortVal", "asc");
        paramsMap.put("reqTime", "2015-12-12 12:30:04");


        ServiceClient.getInstance().getAPIService().getProductList(paramsMap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DeliverInfo>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError-" + e);
                    }

                    @Override
                    public void onNext(DeliverInfo deliverInfo) {
                        Log.d(TAG, "response--" + deliverInfo.getRet());
                        Log.d(TAG, deliverInfo.getRes().getSortType());
                        Log.d(TAG,deliverInfo.getRes().getOrderList().get(0).getgName());
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menuMsg = menu.findItem(R.id.action_msg);
        if (hasNewMessage) {
            menuMsg.setIcon(R.mipmap.icon_msg_read);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_msg) {
//            if (SessionUtil.loginCheck(this)) {
////                hasNewMessage = false;
//                menuMsg.setIcon(R.mipmap.icon_msg);
//                startActivity(new Intent(MainActivity.this, MessageActivity.class));
//            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public MainPresenter createPresenter() {
        mainPresenter = new MainPresenter();
        return mainPresenter;
    }
}
