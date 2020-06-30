package com.nature.ViewClassMeasure.touchevent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.nature.ViewClassMeasure.R;

import java.util.IllformedLocaleException;

import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.actionToString;

public class ViewTouchEventDeliveryActivity extends AppCompatActivity {

    private SwitchCompat switchCompat;
    private SwitchCompat sw_ismoveinterept;
    private TouchEventLinearLayout linearLayout;
    private TouchEventTextView tv;
    private TextView tv_parent_touch_message;
    private SwitchCompat switchCompat_addlistener;
    private SwitchCompat sw_isallowinterept;
    private TextView tv_child_touch_message;
    public static StringBuffer message = new StringBuffer();
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_touch_event_delivery);
        toolbar = new Toolbar(getBaseContext());
        toolbar.setNavigationIcon(R.drawable.ic_launcher_background);
        setActionBar(toolbar);
        initView();
    }

    private void initView() {
        switchCompat = findViewById(R.id.sw_isinterept);
        sw_ismoveinterept = findViewById(R.id.sw_ismoveinterept);
        sw_isallowinterept = findViewById(R.id.sw_isallowinterept);
        switchCompat_addlistener = findViewById(R.id.sw_addlistener);
        linearLayout = findViewById(R.id.ll);
        tv_parent_touch_message = findViewById(R.id.tv_parent_touch_message);
        tv_child_touch_message = findViewById(R.id.tv_child_touch_message);
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                linearLayout.setDownIntercept(isChecked);
            }
        });
        sw_ismoveinterept.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                linearLayout.setIntercept(isChecked);
            }
        });
        sw_isallowinterept.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //该方法只在拦截move,up时生效，viewgruop拦截了down时无效
                tv.getParent().requestDisallowInterceptTouchEvent(isChecked);
            }
        });
        //只有view消费了down事件，才会接受到后续的move，up等事件
        switchCompat_addlistener.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {//当view的clickable或longclickable有一个为真时，ontouchevent为真
                    tv.setClickable(true);
                    Toast.makeText(getBaseContext(), "添加监听事件成功", Toast.LENGTH_SHORT).show();
                } else {
                    tv.setClickable(false);
                }
            }
        });
        tv = findViewById(R.id.tv);
        linearLayout.setLister(new TouchEventLinearLayout.onTouchEventChangLister() {
            @Override
            public void changeMesage(String messsage) {
                tv_parent_touch_message.setText(message.toString());

            }
        });
        tv.setLister(new TouchEventLinearLayout.onTouchEventChangLister() {
            @Override
            public void changeMesage(String messsage) {
                tv_parent_touch_message.setText(message.toString());
            }
        });
    }

    private int action;

    @Override//事件起点
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (action == ev.getAction() && action == ACTION_DOWN) {//重新开始一个事件序列，清空事件流程信息
            ViewTouchEventDeliveryActivity.message = new StringBuffer();
            action = ev.getAction();
        }
        message
                .append("\n")
                .append("activity====")
                .append(actionToString(ev.getAction()))
                .append("======")
                .append("dispatchTouchEvent")
                .append("====>");
        Log.d("touch", "activity====" + MotionEvent.actionToString(ev.getAction()) + "======dispatchTouchEvent==");
        return super.dispatchTouchEvent(ev);
    }

    @Override//事件activity终点，无子View处理情况下，调用activityonTouchEvent处理
    public boolean onTouchEvent(MotionEvent event) {
        message
                .append("\n")
                .append("activity====")
                .append(actionToString(event.getAction()))
                .append("======")
                .append("onTouchEvent")
                .append("====>");
        tv_parent_touch_message.setText(message.toString());
        Log.d("touch", "activity====" + MotionEvent.actionToString(event.getAction()) + "======onTouchEvent==");
        return super.onTouchEvent(event);
    }
}
