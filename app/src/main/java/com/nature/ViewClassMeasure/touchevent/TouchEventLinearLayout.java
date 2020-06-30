package com.nature.ViewClassMeasure.touchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import static android.view.KeyEvent.ACTION_MULTIPLE;
import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_MOVE;
import static android.view.MotionEvent.ACTION_UP;


/**
 * @ProjectName: ViewClassMeasure
 * @Package: com.nature.ViewClassMeasure.touchevent
 * @ClassName: TouchEventLinearLayout
 * @Description: java类作用描述  探究viewGroup的事件分发规则
 * @Author: nature
 * @CreateDate: 2020/6/23 10:07
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/6/23 10:07
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class TouchEventLinearLayout extends LinearLayout {
    StringBuffer sb = new StringBuffer();
    private onTouchEventChangLister lister;
    private int action;

    public void setSb(StringBuffer sb) {
        this.sb = sb;
    }

    public StringBuffer getSb() {
        return sb;
    }

    public onTouchEventChangLister getLister() {
        return lister;
    }

    public void setLister(onTouchEventChangLister lister) {
        this.lister = lister;
    }

    private boolean isIntercept;
    private boolean isDownIntercept;

    public boolean isDownIntercept() {
        return isDownIntercept;
    }

    public void setDownIntercept(boolean downIntercept) {
        isDownIntercept = downIntercept;
    }

    public boolean isIntercept() {
        return isIntercept;
    }

    public void setIntercept(boolean intercept) {
        isIntercept = intercept;
    }

    public TouchEventLinearLayout(Context context) {
        super(context);
    }

    public TouchEventLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchEventLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TouchEventLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        ViewTouchEventDeliveryActivity.message.append("\n")
                .append("父View====")
                .append(MotionEvent.actionToString(ev.getAction()))
                .append("======")
                .append("dispatchTouchEvent")
                .append("====>");
        addListener();
        Log.d("touch", "父View====" + MotionEvent.actionToString(ev.getAction()) + "======dispatchTouchEvent===");
        return super.dispatchTouchEvent(ev);
    }

    private void addListener() {
        if (lister != null) {
            lister.changeMesage(sb.toString());
        }
    }

    //拦截事件
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        ViewTouchEventDeliveryActivity.message.append("\n")
                .append("父View====")
                .append(MotionEvent.actionToString(ev.getAction()))
                .append("======")
                .append("onInterceptTouchEvent")
                .append("====>");
        addListener();
        Log.d("touch", "父View====" + MotionEvent.actionToString(ev.getAction()) + "======onInterceptTouchEvent==");
        switch (ev.getAction()) {
            case ACTION_MOVE:
            case ACTION_UP:
                return isIntercept;
            case ACTION_DOWN:
                return isDownIntercept;
            default:
                return super.onInterceptTouchEvent(ev);

        }
    }

    //消费事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        ViewTouchEventDeliveryActivity.message.append("\n")
                .append("父View====")
                .append(MotionEvent.actionToString(event.getAction()))
                .append("======")
                .append("onTouchEvent")
                .append("====>");
        addListener();
        Log.d("touch", "父View====" + MotionEvent.actionToString(event.getAction()) + "======onTouchEvent==" + super.onTouchEvent(event));
        return super.onTouchEvent(event);
    }

    public interface onTouchEventChangLister {
        void changeMesage(String messsage);
    }
}
