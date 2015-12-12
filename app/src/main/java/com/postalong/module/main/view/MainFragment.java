package com.postalong.module.main.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.postalong.R;
import com.postalong.module.order.view.FindOrderActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by heshaokang on 2015/12/12.
 */
public class MainFragment extends Fragment{
    private MainActivity mainActivity;
    private boolean runGetMsg = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_content_3, container, false);
        ButterKnife.bind(this, view);
        //executionTask();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    /**
     * 网格点击：创建订单
     */
    @OnClick({R.id.main_send_layout, R.id.main_send})
    public void send() {
//        if (NetWorkUtils.isNetWorkUsed(getActivity())) {
//            if (SessionUtil.loginCheck(getActivity())) {
//                startActivity(new Intent(getActivity(), CreateOrderActivity.class));
//            }
//        } else {
//            BaseUtils.Toast(mainActivity.getString(R.string.main_no_net));
//        }
    }

    /**
     * 网格点击：接单列表
     */
    @OnClick(R.id.main_deliver_layout)
    public void deliver() {
        startActivity(new Intent(getActivity(), FindOrderActivity.class));
    }

    /**
     * 网格点击：发行程
     */
    @OnClick(R.id.main_trip_plan_layout)
    public void trip() {
//        if (SessionUtil.loginCheck(getActivity())) {
//            startActivity(new Intent(getActivity(), CreatePlanActivity.class));
//        }
    }

    /**
     * 网格点击：发单列表
     */
    @OnClick({R.id.main_order_layout})
    public void order() {
        //mainActivity.sendOrder();
    }

    /**
     * 网格点击：我的钱包
     */
    @OnClick(R.id.main_wallet_layout)
    public void wallet() {
       // mainActivity.wallet();
    }

    /**
     * 开始消息轮询
     */
    private void executionTask() {
//        if (GlobalApp.token != null) {//判断是否已经登录，如果有
//            Runnable runnable = new Runnable() {
//                @Override
//                public void run() {
//                    // 在此处添加执行的代码
//                    if (runGetMsg) {
//                        requestMsg();
//                    }
//                    handler.postDelayed(this, Constants.messagePollTime);// 20ms后执行this，即runable
//                }
//            };
//            handler.postDelayed(runnable, Constants.messagePollTime);// 打开定时器，20ms后执行runnable操作
//        }
    }

    @Override
    public void onResume() {
        super.onResume();
//        System.out.println("MainFragment3.onResume");
        messageUpdate();
        setRunGetMsg(true);//开启消息轮询
    }

    @Override
    public void onPause() {
        super.onPause();
//        System.out.println("MainFragment3.onPause");
        setRunGetMsg(false);//关闭消息轮询
    }

    private void messageUpdate() {
//        if (GlobalApp.token != null) {//判断是否已经登录，如果有
//            long lastReqTime = SharedPrefsUtil.getLong(Constants.SP_MESSAGE_REQUEST_TIMESTAMP, 0);
//            //时间间隔大于一分钟则重新请求一次 否则直接加载数据库数据
//            Log.d("MainFragment3 lastReqTime", "lastReqTime " + lastReqTime + " System.currentTimeMillis() " + System.currentTimeMillis() + " " + (System.currentTimeMillis() - lastReqTime));
//            if (mainActivity.isFromLoginOrRegister || (System.currentTimeMillis() - lastReqTime > Constants.messageUpdateTime)) {
////                SharedPrefsUtil.putLong(Constants.SP_MESSAGE_REQUEST_TIMESTAMP, lastReqTime);
//                mainActivity.isFromLoginOrRegister = false;
//                requestMsg();
//            }
//        }
    }

    /**
     * 判断是否登录后，才进行请求msg
     */
    private void requestMsg() {
//        if (GlobalApp.token != null) {
//            mainActivity.getMessagePresenter().getMsg();
//        }
    }

    private final Handler handler = new Handler();

    public void setRunGetMsg(boolean runGetMsg) {
        this.runGetMsg = runGetMsg;
    }

}
