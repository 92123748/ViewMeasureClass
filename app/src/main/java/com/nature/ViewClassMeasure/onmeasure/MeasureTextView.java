package com.nature.ViewClassMeasure.onmeasure;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;

/**
 * @ProjectName: ViewClassMeasure
 * @Package: com.nature.ViewClassMeasure
 * @ClassName: MeasureTextView
 * @Description: java类作用描述
 * @Author: nature
 * @CreateDate: 2020/6/22 9:51
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/6/22 9:51
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@SuppressLint("AppCompatCustomView")
public class MeasureTextView extends TextView {

    private int mode;

    public String getMode() {
        return MeasureSpec.toString(mode);
    }


    public MeasureTextView(Context context) {
        super(context);
    }

    public MeasureTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MeasureTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MeasureTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mode = widthMeasureSpec;
        String message = MeasureSpec.toString(mode);
        Log.e("onMeasure", "child message====" + message);
    }
}
