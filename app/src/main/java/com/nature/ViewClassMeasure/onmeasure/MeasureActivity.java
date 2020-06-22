package com.nature.ViewClassMeasure.onmeasure;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.nature.ViewClassMeasure.R;
import com.nature.ViewClassMeasure.onmeasure.MeasureLinerLayout;

/**
 * 探究父MeasureSpec和子MeasureSpec的关系
 */
public class MeasureActivity extends AppCompatActivity {
    MeasureLinerLayout ml_parent;
    private TextView tv_parent_message;
    private RadioGroup rg_parent;
    private RadioButton rb_matchparent;
    private RadioButton rb_excatly;
    private RadioButton rb_wrapcontent;
    private MeasureTextView tv_child;
    private TextView tv_child_message;
    private RadioGroup rg_child;
    private RadioButton rb_cmatchparent;
    private RadioButton rb_cexcatly;
    private RadioButton rb_cwrapcontent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measure);
        initView();
        initListener();
        tv_parent_message.setText("parent的width specMode=" + ml_parent.getWidthMeasureSpecMode());
    }

    //当parent 为atmost  ，子view为match_parent 时。他的specMode可能为 excatly, 值为屏幕显示的最大值，因为进行了二次measure导致childDomin被赋值给予了一个最大值
    private void initListener() {
        rg_parent.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ViewGroup.LayoutParams layoutParams = ml_parent.getLayoutParams();
                switch (checkedId) {
                    case R.id.rb_matchparent:
                        layoutParams.width = layoutParams.MATCH_PARENT;
                        ml_parent.setLayoutParams(layoutParams);
                        break;
                    case R.id.rb_excatly:
                        layoutParams.width = 400;
                        ml_parent.setLayoutParams(layoutParams);
                        break;
                    case R.id.rb_wrapcontent:
                        layoutParams.width = layoutParams.WRAP_CONTENT;
                        ml_parent.setLayoutParams(layoutParams);
                        break;
                }
                ml_parent.post(new Runnable() {
                    @Override
                    public void run() {
                        tv_parent_message.setText("parent的width MeasureSpce=" + ml_parent.getWidthMeasureSpecMode());
                        tv_child_message.setText("child的width MeasureSpce=" + tv_child.getMode());
                    }
                });
            }
        });
        rg_child.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ViewGroup.LayoutParams layoutParams = tv_child.getLayoutParams();
                switch (checkedId) {
                    case R.id.rb_cmatchparent:
                        layoutParams.width = layoutParams.MATCH_PARENT;
                        tv_child.setLayoutParams(layoutParams);
                        break;
                    case R.id.rb_cexcatly:
                        layoutParams.width = 400;
                        tv_child.setLayoutParams(layoutParams);
                        break;
                    case R.id.rb_cwrapcontent:
                        layoutParams.width = layoutParams.WRAP_CONTENT;
                        tv_child.setLayoutParams(layoutParams);
                        break;
                }
                tv_child.post(new Runnable() {
                    @Override
                    public void run() {
                        tv_parent_message.setText("parent的width MeasureSpce=" + ml_parent.getWidthMeasureSpecMode());
                        tv_child_message.setText("child的width MeasureSpce=" + tv_child.getMode());
                    }
                });
            }
        });

    }

    private void initView() {
        ml_parent = findViewById(R.id.ml_parent);
        tv_parent_message = findViewById(R.id.tv_parent_message);
        rg_parent = findViewById(R.id.rg_parent);
        rb_matchparent = findViewById(R.id.rb_matchparent);
        rb_excatly = findViewById(R.id.rb_excatly);
        rb_wrapcontent = findViewById(R.id.rb_wrapcontent);
        tv_child = findViewById(R.id.tv_child);
        tv_child_message = findViewById(R.id.tv_child_message);
        rg_child = findViewById(R.id.rg_child);
        rb_cmatchparent = findViewById(R.id.rb_cmatchparent);
        rb_cexcatly = findViewById(R.id.rb_cexcatly);
        rb_cwrapcontent = findViewById(R.id.rb_cwrapcontent);
    }
}
