package com.brandlee.leeadapter;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: BaseAdapter
 * @Description:
 * @Author liqi1
 * @Date 17/4/19
 */

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {
    public final static int ITEM_TYPE_HEADER = 55000;
    public final static int ITEM_TYPE_FOOTER = 60000;
    public final static int FIXED_ITEM_LOAD_MORE = 50000;
    public final static int COUNT_FIXED_ITEM = 1;
    public final static int PER_PAGE_SIZE = 15;

    private SparseArray<View> mHeaderViews = new SparseArray<>();
    private SparseArray<View> mFooterViews = new SparseArray<>();
    protected MultiItemType<T> multiItemType;

    // 数据源
    private List<T> mData;

    protected BaseFooter loadMoreFooterView;

    public BaseAdapter(RecyclerView mRecyclerView) {
        mData = new ArrayList<>();
        loadMoreFooterView = new SimpleFooter(mRecyclerView.getContext(), mRecyclerView);
    }

    public void refreshData() {

    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == FIXED_ITEM_LOAD_MORE) {
            return new BaseViewHolder(loadMoreFooterView.getContainerView());
        } else if (viewType >= ITEM_TYPE_HEADER && viewType < ITEM_TYPE_FOOTER) {
            return new BaseViewHolder(mHeaderViews.get(viewType));
        } else if (viewType >= ITEM_TYPE_FOOTER) {
            return new BaseViewHolder(mFooterViews.get(viewType));
        }
        int layoutResId = getAdapterLayout();
        if (multiItemType != null) {
            layoutResId = multiItemType.getLayoutId(viewType);
        }
        View inflate = LayoutInflater.from(parent.getContext()).inflate(layoutResId, parent, false);
        return new BaseViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (getItemViewType(position) < FIXED_ITEM_LOAD_MORE) {
            bindData(holder, mData.get(getRealDataPosition(position)));
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1) {
            return FIXED_ITEM_LOAD_MORE;
        } else if (isHeader(position)) {
            return ITEM_TYPE_HEADER + position;
        } else if (isFooter(position)) {
            return ITEM_TYPE_FOOTER + (position - mHeaderViews.size() - mData.size());
        } else if (multiItemType != null) {
            int realPosition = getRealDataPosition(position);
            return multiItemType.getItemViewType(realPosition, mData.get(realPosition));
        } else {
            return super.getItemViewType(position);
        }
    }

    private int getRealDataPosition(int mixedPosition) {
        int realPosition = mixedPosition - mHeaderViews.size();
        if (realPosition >= mData.size()) {
            realPosition = -(realPosition + 1 - mData.size());
        }
        return realPosition;
    }

    protected abstract int getAdapterLayout();

    protected abstract void bindData(BaseViewHolder holder, T data);

    public void addHeaderView(View headerView) {
        mHeaderViews.put(mHeaderViews.size() + ITEM_TYPE_HEADER, headerView);
    }

    public void addFooterView(View footerView) {
        mFooterViews.put(mFooterViews.size() + ITEM_TYPE_FOOTER, footerView);
    }

    private boolean isHeader(int position) {
        return mHeaderViews.size() > 0 && position < mHeaderViews.size();
    }

    private boolean isFooter(int position) {
        return mFooterViews.size() > 0 && position >= getItemCount() - mFooterViews.size() - COUNT_FIXED_ITEM;
    }

    /**
     * 当LayoutManager是GridLayoutManager时，设置header和footer占据的列数
     *
     * @param recyclerView recyclerView
     */
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        final RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager gridManager = ((GridLayoutManager) layoutManager);
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return (isFooter(position) || isHeader(position)) ? gridManager.getSpanCount() : 1;
                }
            });
        }
    }

    /**
     * 当LayoutManager是StaggeredGridLayoutManager时，设置header和footer占据的列数
     *
     * @param holder holder
     */
    @Override
    public void onViewAttachedToWindow(BaseViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        final ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        if (layoutParams != null && layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            StaggeredGridLayoutManager.LayoutParams params = (StaggeredGridLayoutManager.LayoutParams) layoutParams;
            params.setFullSpan(isHeader(holder.getLayoutPosition()) || isFooter(holder.getLayoutPosition()));
        }
    }

    public void setOnLoadMoreListener(RecyclerView recyclerView, final OnLoadMoreListener onLoadMoreListener) {
        if (recyclerView != null && onLoadMoreListener != null) {
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                    if (!loadMoreFooterView.isEnable) {
                        return;
                    }
                    int lastPosition = -1;
                    if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                        if (layoutManager instanceof GridLayoutManager) {
                            lastPosition = ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
                        } else if (layoutManager instanceof LinearLayoutManager) {
                            lastPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                            int[] lastPositions = new int[((StaggeredGridLayoutManager) layoutManager).getSpanCount()];
                            ((StaggeredGridLayoutManager) layoutManager).findLastVisibleItemPositions(lastPositions);
                            lastPosition = findMax(lastPositions);
                        }
                        if (loadMoreFooterView.isNeedLoadMore(lastPosition, recyclerView.getLayoutManager().getItemCount())) {
                            onLoadMoreListener.loadMore(loadMoreFooterView.currentPage);
                        }
                    }
                }

                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                }
            });
        }
    }

    private static int findMax(int[] lastPositions) {
        int max = lastPositions[0];
        for (int value : lastPositions) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

}
