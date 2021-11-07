package com.example.competedata9.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.competedata9.HomeActivity;
import com.example.competedata9.R;

public class HomeSkip1Activity extends AppCompatActivity {

    private ImageView ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_skip1);
        initView();
    }

    private void initView() {
        ivBack = findViewById(R.id.iv_back);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeSkip1Activity.this, HomeActivity.class);
                intent.putExtra("id",0);
                startActivity(intent);
            }
        });
    }
}