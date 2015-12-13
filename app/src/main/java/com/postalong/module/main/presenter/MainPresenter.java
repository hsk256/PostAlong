package com.postalong.module.main.presenter;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.postalong.R;
import com.postalong.base.BasePresenter;
import com.postalong.module.main.view.MainView;

/**
 * Created by heshaokang on 2015/12/12.
 */
public class MainPresenter extends BasePresenter<MainView> {


    /**
     * 切换不同内容页 fragment
     */
    public void replaceFragment(AppCompatActivity activity,Fragment fragment) {
        activity.getSupportFragmentManager().beginTransaction()
                .replace(R.id.fr_content,fragment)
                .commitAllowingStateLoss();
    }
}
