package com.example.admin.zidingviewapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作者：created  by jash on 2017/9/14
 * 版本：1.0.0.
 */

public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int with=getMyView(100,widthMeasureSpec);
        int hight=getMyView(100,heightMeasureSpec);
        if(with>hight){
            with=hight;
        }else {
            hight=with;
        }
        setMeasuredDimension(with,hight);
    }
    public int  getMyView(int defaultSize,int measureSpec){
        int msize=defaultSize;
        int mode=MeasureSpec.getMode(measureSpec);
        int size=MeasureSpec.getSize(measureSpec);
        if(mode==MeasureSpec.UNSPECIFIED){
            msize=defaultSize;
        }else if(mode==MeasureSpec.AT_MOST){
            msize=msize;
        }else if(mode==MeasureSpec.EXACTLY){
            msize=size;
        }

        return  msize;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int r=getMeasuredWidth()/2;
        Paint paint=new Paint();
        paint.setColor(Color.YELLOW);
        int centrX=getLeft()+r;
        int centrY=getTop()+r;
        canvas.drawCircle(centrX,centrY,r,paint);
    }

    private void styrionf(){
        // 重绘方法
        invalidate();
    }
}
