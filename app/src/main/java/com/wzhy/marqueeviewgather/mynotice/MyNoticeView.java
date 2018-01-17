package com.wzhy.marqueeviewgather.mynotice;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;

import com.wzhy.marqueeviewgather.app.MyApp;


/**
 * Created by Administrator on 2017-12-15 0015.
 */

public class MyNoticeView extends View {

    private Paint mPaint;
    private TextPaint mTextPaint;
    private int centerY;
    private int baseLineY;
    private int centerX;
    private int radius;

    public MyNoticeView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG | Paint.LINEAR_TEXT_FLAG);

        WindowManager windowManager = (WindowManager) MyApp.getAppContext().getSystemService(Context.WINDOW_SERVICE);
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        centerY = point.y / 2;
        centerX = point.x / 2;
        mTextPaint.setTextSize(32);
        mTextPaint.setColor(0xFF00AA00);
        mTextPaint.setTextAlign(Paint.Align.CENTER);

        radius = 80;

    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawText("定风波", centerX, baseLineY,mTextPaint);
    }

    public void startScroll() {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(-180, 180).setDuration(2400);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int time = (int) animation.getAnimatedValue();
                Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
                baseLineY = ((int) ((int) (centerY - (fontMetrics.ascent + fontMetrics.descent) / 2) + radius * Math.sin(Math.toRadians(time))));
                //Log.d("animator", "time -->" + baseLineY);
                float rat = (float) (3072 / (2048 - radius + radius * Math.cos(Math.toRadians(time))));
                mTextPaint.setTextSize(32 * rat);
                mTextPaint.setAlpha(((int) (255 * rat)));
                invalidate();
            }
        });
        valueAnimator.setRepeatCount(10);
        valueAnimator.start();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
