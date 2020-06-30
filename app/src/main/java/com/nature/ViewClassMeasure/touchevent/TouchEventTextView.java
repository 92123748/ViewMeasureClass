package com.nature.ViewClassMeasure.touchevent;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

import androidx.annotation.Nullable;

/**
 * @ProjectName: ViewClassMeasure
 * @Package: com.nature.ViewClassMeasure.touchevent
 * @ClassName: TouchEventTextView
 * @Description: java类作用描述
 * @Author: nature
 * @CreateDate: 2020/6/23 10:08
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/6/23 10:08
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@SuppressLint("AppCompatCustomView")
public class TouchEventTextView extends TextView {
    private TouchEventLinearLayout.onTouchEventChangLister lister;
    private int action;

    public TouchEventLinearLayout.onTouchEventChangLister getLister() {
        return lister;
    }

    public void setLister(TouchEventLinearLayout.onTouchEventChangLister lister) {
        this.lister = lister;
    }

    public StringBuffer getSb() {
        return sb;
    }

    public void setSb(StringBuffer sb) {
        this.sb = sb;
    }

    private StringBuffer sb = new StringBuffer();

    public TouchEventTextView(Context context) {
        super(context);
    }

    public TouchEventTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchEventTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TouchEventTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public String getTouchMessage() {
        return sb.toString();
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {

        ViewTouchEventDeliveryActivity.message.append("\n")
                .append("子View====")
                .append(MotionEvent.actionToString(event.getAction()))
                .append("======")
                .append("dispatchTouchEvent")
                .append("====>");

        addListener();
        Log.d("touch", "子View====" + MotionEvent.actionToString(event.getAction()) + "======dispatchTouchEvent==");
        return super.dispatchTouchEvent(event);
    }

    //消费事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        ViewTouchEventDeliveryActivity.message.append("\n")
                .append("子View====")
                .append(MotionEvent.actionToString(event.getAction()))
                .append("======")
                .append("onTouchEvent")
                .append("====>");
        addListener();
        Log.d("touch", "子View====" + MotionEvent.actionToString(event.getAction()) + "======onTouchEvent==");
        return super.onTouchEvent(event);
    }

    private void addListener() {
        if (lister != null) {
            lister.changeMesage(sb.toString());
        }
    }
}
