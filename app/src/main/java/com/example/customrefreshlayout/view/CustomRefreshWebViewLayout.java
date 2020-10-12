package com.example.customrefreshlayout.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.customrefreshlayout.R;

/**
 * @author by chenlp
 * @date 2020/9/28
 * @describe
 */
public class CustomRefreshRecyclerLayout extends CustomRefreshLayout {

    private OnRefreshListener mOnRefreshListener;

    private ImageView mImg_down_refresh;
    private ImageView mImg_up_refresh;
    private TextView mTv_down_refresh_status;
    private TextView mTv_up_refresh_status;

    public CustomRefreshRecyclerLayout(Context context) {
        super(context);

    }

    public CustomRefreshRecyclerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public CustomRefreshRecyclerLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    protected void initView() {
        super.initView();
//        setUpRefresh(true);
        mTv_down_refresh_status = findViewById(R.id.tv_down_refresh_status);
        mImg_down_refresh = findViewById(R.id.img_down_refresh);
        mTv_up_refresh_status = findViewById(R.id.tv_up_refresh_status);
        mImg_up_refresh = findViewById(R.id.img_up_refresh);
    }


    @Override
    protected void downDealWithRefreshing() {
        mImg_down_refresh.setImageResource(R.drawable.up_refresh);
        mTv_down_refresh_status.setText("正在刷新");
        postDelayed(new Runnable() {
            @Override
            public void run() {
                mTv_down_refresh_status.setText("刷新成功");
                if (mOnRefreshListener!=null){
                    mOnRefreshListener.downRefresh();
                }
            }
        }, 500);

    }

    @Override
    protected void downDealWithDown() {
        mImg_down_refresh.setImageResource(R.drawable.down_refresh);
    }

    @Override
    protected void downDealWithUp() {
        mImg_down_refresh.setImageResource(R.drawable.up_refresh);
    }

    @Override
    protected void downNotReachBottom() {
        mTv_down_refresh_status.setText("继续下拉");
    }

    @Override
    protected void downReachBottom() {
        mTv_down_refresh_status.setText("松开刷新");
    }

    @Override
    protected void upDealWithUp() {
        mImg_up_refresh.setImageResource(R.drawable.up_refresh);
    }

    @Override
    protected void upDealWithDown() {
        mImg_up_refresh.setImageResource(R.drawable.down_refresh);
    }

    @Override
    protected void upNotReachTop() {
        mTv_up_refresh_status.setText("继续上拉");
    }

    @Override
    protected void upReachTop() {
        mTv_up_refresh_status.setText("加载成功");

    }

    @Override
    protected void upDealWithRefreshing() {
//        mImg_up_refresh.setImageResource(R.drawable.down_refresh);
//        mTv_up_refresh_status.setText("正在加载");
        postDelayed(new Runnable() {
            @Override
            public void run() {

                if (mOnRefreshListener!=null){
                    mOnRefreshListener.upRefresh();
                }
            }
        }, 500);
    }

    @Override
    protected void addHeadView() {
        LayoutInflater.from(getContext()).inflate(R.layout.recycler_head_view, this);
    }

    @Override
    protected void addFootView() {
        LayoutInflater.from(getContext()).inflate(R.layout.recycler_foot_view, this);
    }

    @Override
    protected View getHeadView() {
        return findViewById(R.id.cl_head);
    }

    @Override
    protected View getFootView() {
        return findViewById(R.id.cl_foot);
    }

    public interface OnRefreshListener {
        void downRefresh();

        void upRefresh();
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        mOnRefreshListener = onRefreshListener;
    }

}
