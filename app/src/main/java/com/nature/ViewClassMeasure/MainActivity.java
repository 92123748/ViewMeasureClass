package com.nature.ViewClassMeasure;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.nature.ViewClassMeasure.onmeasure.MeasureActivity;
import com.nature.ViewClassMeasure.onmeasure.MeasureLinerLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        findViewById(R.id.btn_go_measure).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MeasureActivity.class));
            }
        });
    }

    private void initView() {
        MeasureLinerLayout ll_200 = findViewById(R.id.ll_200);
        MeasureLinerLayout ll_wrapcontent = findViewById(R.id.ll_wrapcontent);
        TextView tv0 = findViewById(R.id.tv0);
        tv0.setText("父布局WidthMeasureSpec：=" + ll_200.getWidthMeasureSpecMode());
        TextView tv1 = findViewById(R.id.tv1);
        TextView tv2 = findViewById(R.id.tv2);
        TextView tv3 = findViewById(R.id.tv3);
        TextView tv4 = findViewById(R.id.tv4);
        tv4.setText("父布局WidthMeasureSpec：=" + ll_wrapcontent.getWidthMeasureSpecMode());
        TextView tv5 = findViewById(R.id.tv5);
        TextView tv6 = findViewById(R.id.tv6);
        TextView tv7 = findViewById(R.id.tv7);
    }
}
