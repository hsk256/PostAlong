package com.postalong.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.postalong.R;

import butterknife.ButterKnife;

/**
 * Created by heshaokang on 2015/12/12.
 */
public abstract class BaseActivity<V,T extends BasePresenter<V>> extends AppCompatActivity {
    protected T presenter;

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        ButterKnife.bind(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        presenter.attachView((V)this);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home) {
            finish();
            overridePendingTransition(0, R.anim.slide_right_out);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    public abstract T createPresenter();
}
