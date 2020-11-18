package com.example.customrefreshlayout.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.example.customrefreshlayout.R;

/**
 * @author by chenlp
 * @date 2020/10/12
 * @describe
 */
public class CustomRefreshScrollViewLayout extends CustomRefreshLayout {

    private View mHeadView;
    private LoadingView mLoadingView;
    private int percent;

    public CustomRefreshScrollViewLayout(Context context) {
        super(context);
    }

    public CustomRefreshScrollViewLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomRefreshScrollViewLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void initView() {
        super.initView();
        mLoadingView = mHeadView.findViewById(R.id.img_load_refresh);
        setOnDistanceChanged(new OnDistanceChanged() {
            @Override
            public void onDistanceChanged(int distance) {
                mLoadingView.setPercent((distance / (float)getHeadViewHeight()));
                Log.e("clp--------", "onDistanceChanged: distance"+distance +"getHeadViewHeight()" + getHeadViewHeight()
                        +"distance / getHeadViewHeight()" + distance / getHeadViewHeight());
            }
        });
    }

    @Override
    protected void addHeadView() {
        mHeadView = LayoutInflater.from(getContext()).inflate(R.layout.scroll_view_head_view, this);
    }

    @Override
    protected void addFootView() {

    }

    @Override
    protected View getHeadView() {
        return findViewById(R.id.cl_head);
    }

    @Override
    protected View getFootView() {
        return null;
    }
}

