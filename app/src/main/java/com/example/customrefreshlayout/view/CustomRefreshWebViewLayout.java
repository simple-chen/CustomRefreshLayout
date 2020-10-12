package com.example.customrefreshlayout.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.customrefreshlayout.R;

/**
 * @author by chenlp
 * @date 2020/9/28
 * @describe
 */
public class CustomRefreshWebViewLayout extends CustomRefreshLayout {


    private ImageView mImg_down_refresh;
    private Animation mCircle_anim;


    public CustomRefreshWebViewLayout(Context context) {
        this(context, null);

    }

    public CustomRefreshWebViewLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public CustomRefreshWebViewLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mCircle_anim = AnimationUtils.loadAnimation(context, R.anim.rotate);
    }


    protected void initView() {
        super.initView();
        mImg_down_refresh = findViewById(R.id.img_down_refresh);
    }


    @Override
    protected void downDealWithDown() {
        mImg_down_refresh.startAnimation(mCircle_anim);
    }


    @Override
    protected void dealWithHide() {
        mImg_down_refresh.clearAnimation();
    }

    @Override
    protected void addHeadView() {

        LayoutInflater.from(getContext()).inflate(R.layout.webview_head_view, this);
    }

    @Override
    protected View getHeadView() {
        return findViewById(R.id.cl_head);
    }

    @Override
    protected void addFootView() {


    }

    @Override
    protected View getFootView() {
        return null;
    }
}
