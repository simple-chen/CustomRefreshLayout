package com.example.customrefreshlayout.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.customrefreshlayout.R;
import com.example.customrefreshlayout.utils.DensityUtil;

/**
 * @author by chenlp
 * @date 2020/10/13
 * @describe
 */
public class LoadingView extends View {

    private int mRadius;
    private int mCx;
    private int mCy;
    private float mSweepAngle;
    private float mStartAngle;
    private Paint mUpperCirclePaint;
    private Paint mBottomCirclePaint;
    private ValueAnimator mValueAnimator;

    public LoadingView(Context context) {
        this(context, null);
    }

    public LoadingView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        int borderWidth = DensityUtil.dip2px(getContext(), 3);
        mBottomCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBottomCirclePaint.setStrokeWidth(borderWidth);
        mBottomCirclePaint.setStyle(Paint.Style.STROKE);
        mBottomCirclePaint.setColor(getResources().getColor(R.color.gray));

        mUpperCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mUpperCirclePaint.setStrokeWidth(borderWidth);
        mUpperCirclePaint.setStyle(Paint.Style.STROKE);
        mUpperCirclePaint.setColor(getResources().getColor(R.color.colorPrimary));


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawBottomCircle(canvas);
        drawUpperCircle(canvas);

    }

    private void drawUpperCircle(Canvas canvas) {
        RectF rectF = new RectF(mCx - mRadius, mCy - mRadius, mCx + mRadius, mCy + mRadius);
        canvas.drawArc(rectF, mStartAngle, mSweepAngle, false, mUpperCirclePaint);
    }

    private void startAnimator() {
        mValueAnimator = ValueAnimator.ofFloat(0, mSweepAngle);
        mValueAnimator.setDuration(30000);
        mValueAnimator.start();
        mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                postInvalidate();
            }
        });
        mValueAnimator.start();
    }

    private void drawBottomCircle(Canvas canvas) {
        mRadius = DensityUtil.dip2px(getContext(), 20);
        mCx = getWidth() / 2;
        mCy = getHeight() / 2;
        canvas.drawCircle(mCx, mCy, mRadius, mBottomCirclePaint);
    }

    public void setPercent(float percent) {
            mSweepAngle = percent * 360;
            Log.e("clp", "setPercent: mSweepAngle" + mSweepAngle);
            startAnimator();
    }


    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startLoadingAnimator();

    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopLoadingAnimator();
    }

    private void stopLoadingAnimator() {
        if (mValueAnimator == null) {
            return;
        }
        mValueAnimator.end();
        mStartAngle = 0;
    }

    private void startLoadingAnimator() {
        if (mValueAnimator != null && !mValueAnimator.isStarted()) {
            mSweepAngle = 0;
            mValueAnimator.start();
        }
    }
}
