package com.nature.ViewClassMeasure.onmeasure;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

/**
 * @ProjectName: ViewClassMeasure
 * @Package: com.nature.ViewClassMeasure
 * @ClassName: MeasureLinerLayout
 * @Description: java类作用描述
 * @Author: nature
 * @CreateDate: 2020/6/17 17:03
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/6/17 17:03
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class MeasureLinerLayout extends LinearLayout {
    public MeasureLinerLayout(Context context) {
        super(context);
    }

    private int widthMeasureSpecMode;

    public String getWidthMeasureSpecMode() {
        return MeasureSpec.toString(widthMeasureSpecMode);
    }

    public void setWidthMeasureSpecMode(int widthMeasureSpecMode) {
        this.widthMeasureSpecMode = widthMeasureSpecMode;
    }

    public MeasureLinerLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MeasureLinerLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MeasureLinerLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

    }

    @Override
    protected void measureChild(View child, int parentWidthMeasureSpec, int parentHeightMeasureSpec) {
        super.measureChild(child, parentWidthMeasureSpec, parentHeightMeasureSpec);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        widthMeasureSpecMode = widthMeasureSpec;
    }
}
