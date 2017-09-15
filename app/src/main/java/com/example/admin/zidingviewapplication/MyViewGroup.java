package com.example.admin.zidingviewapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * 作者：created  by jash on 2017/9/14
 * 版本：1.0.0.
 */

public class MyViewGroup extends ViewGroup {
    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewGroup(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec,heightMeasureSpec);
        int withmode=MeasureSpec.getMode(widthMeasureSpec);
        int withsize=MeasureSpec.getSize(widthMeasureSpec);
        int highmode=MeasureSpec.getMode(heightMeasureSpec);
        int hightSize=MeasureSpec.getSize(widthMeasureSpec);
        int child=getChildCount();
        if(child==0){
            setMeasuredDimension(0,0);
        }else {
            if(withmode==MeasureSpec.AT_MOST && highmode==MeasureSpec.AT_MOST){
                int height = getTotleHeight();
                int width = getMaxChildWidth();
                setMeasuredDimension(width,height);
            }else if(withmode==MeasureSpec.AT_MOST){
                setMeasuredDimension(getMaxChildWidth(),hightSize);
            }else if(highmode==MeasureSpec.AT_MOST){
                setMeasuredDimension(withsize,getTotleHeight());
            }
        }

    }
    // 计算所有view的总和
    private   int getTotleHeight(){
        int chhild=getChildCount();
        int mHidth = 0;
        for (int i = 0; i < chhild; i++) {
            View childView=getChildAt(i);
            mHidth=mHidth+childView.getMeasuredHeight();
        }


        return mHidth;
    }
    //计算每个View的最大值
    private int getMaxChildWidth(){
        int chhild=getChildCount();
        int maxWith=0;
        for (int i = 0; i < chhild; i++) {
            View childView=getChildAt(i);
            if(maxWith<childView.getMeasuredWidth()){
                maxWith=childView.getMeasuredWidth();
            }

        }


        return maxWith;
    }



    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int count = getChildCount();
        //记录当前的高度位置
        int curHeight = 0;
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            int height = child.getMeasuredHeight();
            int width = child.getMeasuredWidth();
            child.layout(l, curHeight, l + width, curHeight + height);
            curHeight += height;
        }



    }
}
