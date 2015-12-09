package com.postalong.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import com.postalong.R;


/**
 * 用于分页加载的ListView
 * Created by heyiyong on 2015/11/19.
 * modify by heshaokang
 */
public class LoadMoreListView extends ListView implements AbsListView.OnScrollListener {
    private int visibleLastIndex;
    private boolean hasMore = false;//是否有更多数据
    private boolean loading = false;//当前是否正在加载
    private OnLoadMoreListener loadMoreListener;
    private View loadMoreView; // 正在加载View
    public LoadMoreListView(Context context) {
        super(context);
        init();
    }

    public LoadMoreListView(Context context, AttributeSet attr) {
        super(context, attr);
        init();
    }

    public LoadMoreListView(Context context, AttributeSet attr, int defStyle) {
        super(context, attr, defStyle);
        init();
    }

    private void init() {
        loadMoreView = View.inflate(getContext(), R.layout.layout_load_more, null);
        addFooterView(loadMoreView);
        loadMoreView.setVisibility(View.GONE);
        setOnScrollListener(this);
    }

    public void addLoadMoreFooterView() {
        if (hasMore) {//还有更多数据的情况下，要设置正在加载这个item放到listView的最下面
            if (getFooterViewsCount() == 0) {//保证只有一个footerView
                addFooterView(loadMoreView);
            }
            loadMoreView.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 移除footview
     */
    public void removeLoadMoreFooterView() {
        removeFooterView(loadMoreView);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (scrollState == SCROLL_STATE_IDLE//空闲状态（非滑动）
                && visibleLastIndex == getAdapter().getCount()) {//到了最后一个
            if (hasMore) {//仍有数据
                if (!loading) {//没有正在加载
                    loadMoreListener.onLoadMore();
                }
            }
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        visibleLastIndex = firstVisibleItem + visibleItemCount;//记录当前可看到的最后一个item的index
    }

    public interface OnLoadMoreListener {
        void onLoadMore();
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
        if (!hasMore) {
            removeLoadMoreFooterView();
        } else {
            addLoadMoreFooterView();
        }
    }

    /**
     * 判断并设置是否还有更多数据
     *
     * @param requestCount 请求的页容量
     * @param resultCount  结果返回多少条
     */
    public void setHasMore(int requestCount, int resultCount) {
        hasMore = resultCount == requestCount; // 当且仅当请求数量与返回数量相等的时候，才有下一页
        setHasMore(hasMore);
    }

    public boolean isLoading() {
        return loading;
    }

    public void setLoading(boolean loading) {
        this.loading = loading;
    }

    public OnLoadMoreListener getLoadMoreListener() {
        return loadMoreListener;
    }

    public void setLoadMoreListener(OnLoadMoreListener loadMoreListener) {
        this.loadMoreListener = loadMoreListener;
    }

    public boolean isHasMore() {
        return hasMore;
    }

}
