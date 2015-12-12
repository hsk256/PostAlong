package com.postalong.module.order.view;

import android.os.Bundle;

import com.postalong.base.BaseActivity;
import com.postalong.module.order.presenter.FindOrderPresenter;

/**
 * Created by heshaokang on 2015/12/12.
 */
public class FindOrderActivity extends BaseActivity<FindOrderView,FindOrderPresenter> implements FindOrderView{


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    public FindOrderPresenter createPresenter() {
        return new FindOrderPresenter();
    }
}
