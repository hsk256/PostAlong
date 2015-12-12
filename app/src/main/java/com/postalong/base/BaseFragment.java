package com.postalong.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by heshaokang on 2015/12/12.
 */
public abstract class BaseFragment<V,T extends BasePresenter<V>> extends Fragment{

    protected T presenter;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = createPresenter();
        presenter.attachView((V)this);
    }


    @Override
    public void onDestroyView() {
        presenter.detachView();
    }

    public abstract T createPresenter();
}
