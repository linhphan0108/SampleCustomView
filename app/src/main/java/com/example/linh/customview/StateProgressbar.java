package com.example.linh.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;

/**
 * Created by linh on 2/19/2017.
 */

public class StateProgressbar extends BaseCustomView {

    private Drawable bg;
    private Paint gradientProgressPaint;

    public StateProgressbar(Context context) {
        super(context);
    }

    public StateProgressbar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public StateProgressbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public StateProgressbar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        int left = getPaddingLeft();
        int top = getPaddingTop();
        int right = getWidth() - getPaddingRight();
        int bottom = getHeight() - getPaddingBottom();
        bg.setBounds(left, top, right, bottom);
        bg.draw(canvas);

        //gradient progress
        int progressPadding = 4;
        int startX = left + progressPadding;
        int startY = top + progressPadding;
        int endX = right - progressPadding;
        int endY = bottom - progressPadding;
        Shader shader = new LinearGradient(startX, startY, startX, bottom, Color.YELLOW, Color.BLUE, Shader.TileMode.CLAMP);
        gradientProgressPaint = new Paint();
        gradientProgressPaint.setShader(shader);
        canvas.drawRoundRect(new RectF(startX, startY, endX, endY), 40, 40, gradientProgressPaint);
//        canvas.drawRoundRect(new RectF(0, 100, 100, 200), 6, 6, gradientProgressPaint);
    }

    @Override
    protected void constructor(Context context, AttributeSet attrs, int defStyleAttr) {
        bg = getResources().getDrawable(R.drawable.bg_voting_bar_body);
        setMinimumDimension(bg.getIntrinsicWidth()/3, bg.getIntrinsicHeight()/3);


    }

    @Override
    protected int hGetMaximumHeight() {
        return bg.getIntrinsicHeight();
    }

    @Override
    protected int hGetMaximumWidth() {
        return bg.getIntrinsicWidth();
    }

    private void setMinimumDimension(int minWith, int minHeight){
        setMinimumWidth(minWith);
        setMinimumHeight(minHeight);
    }
}
