package com.example.admin.zidingviewapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作者：created  by jash on 2017/9/15
 * 版本：1.0.0.
 */

public class MyTView extends View {
    private Paint myPaint;
    private static final String myString1 = "2006-2011上半年中国移动互联网行业各年度投资情况";
    private static final String myString2 = "来源：清科研究中心 2011.08";
    private Context context;
    public MyTView(Context context) {
        super(context);
        this.context=context;
    }

    public MyTView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        myPaint=new Paint();
        myPaint.setColor(Color.BLACK);
        myPaint.setTextSize(18);
        canvas.drawText(myString1,20,20,myPaint);
        canvas.drawLine(50,100,50,500,myPaint);// 纵坐标
        canvas.drawLine(50,500,400,500,myPaint);// 横坐标
        int[] array1=new int[]{0, 50, 100, 150, 200, 250, 300,350};
        //绘制刻度
        myPaint.setTextSize(10);// 设置文字大小
        canvas.drawText("单位：百万美元",20,90,myPaint);
        for (int i = 0; i < array1.length; i++) {
            canvas.drawLine(50,500-array1[i],54,500-array1[i],myPaint);
            canvas.drawText(array1[i]+"",20,500-array1[i], myPaint);
        }
        //绘制横坐标文字
        String[] array2 = new String[]{"2008年", "2009年", "2010年", "2011上半年"};
        for (int i = 0; i < array2.length; i++) {
            canvas.drawText(array2[i], array1[i] +0, 520, myPaint);
        }
        //绘制条形图
        myPaint.setColor(Color.BLUE); //设置画笔颜色
        myPaint.setStyle(Paint.Style.FILL); //设置填充
        canvas.drawRect(new Rect(90, 500 - 56, 110, 500), myPaint);//画一个矩形,前两个参数是矩形左上角坐标，后两个参数是右下角坐标
        canvas.drawRect(new Rect(140, 500 - 98, 160, 500), myPaint);//第二个矩形
        canvas.drawRect(new Rect(190, 500 - 207, 210, 500), myPaint);//第三个矩形
        canvas.drawRect(new Rect(240, 500 - 318, 260, 500), myPaint);//第四个矩形
        myPaint.setColor(Color.BLACK); //设置画笔颜色
        canvas.drawText("56.32", 88, 500 - 58, myPaint);//第一个矩形的数字说明
        canvas.drawText("98.00", 138, 500 - 100, myPaint);
        canvas.drawText("207.65", 188, 500 - 209, myPaint);
        canvas.drawText("318.30", 238, 500 - 320, myPaint);
        //绘制出处
        myPaint.setColor(Color.BLACK); //设置画笔颜色
        myPaint.setTextSize(16);//设置文字大小
        canvas.drawText(myString2, 20, 560, myPaint);

    }


}
