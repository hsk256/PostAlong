package com.postalong.base;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by heshaokang on 2015/12/12.
 * Presenter基类 持有view(Activity or Fragment or ViewGroup)的弱引用
 */
public abstract class BasePresenter<T> {
    protected Reference<T> mViewRef;

    /**
     * view 绑定到presenter
     * @param view
     */
    public void attachView(T view) {
        mViewRef = new WeakReference<T>(view);
    }

    /**
     * 获取view
     * @return
     */
    protected T getView() {
        return mViewRef.get();
    }

    /**
     * 判断当前Presenter 是否持有view的引用
     * @return
     */
    public boolean isViewAttached() {
        return mViewRef!=null && mViewRef.get()!=null;
    }

    /**
     * 解绑
     */
    public void detachView() {

        if(mViewRef!=null) {
            mViewRef.clear();
            mViewRef = null;
        }

    }

}
