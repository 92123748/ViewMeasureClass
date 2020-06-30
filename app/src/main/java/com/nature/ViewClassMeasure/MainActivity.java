package com.nature.ViewClassMeasure;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.nature.ViewClassMeasure.onmeasure.MeasureActivity;
import com.nature.ViewClassMeasure.touchevent.ViewTouchEventDeliveryActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        findViewById(R.id.btn_go_measure).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MeasureActivity.class));
            }
        });
        findViewById(R.id.btn_go_eventtouch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ViewTouchEventDeliveryActivity.class));
            }
        });
    }
}
