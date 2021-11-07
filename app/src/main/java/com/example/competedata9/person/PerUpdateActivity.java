package com.example.competedata9.person;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.competedata9.HomeActivity;
import com.example.competedata9.R;

public class PerUpdateActivity extends AppCompatActivity {

    private ImageView ivBack;
    private Button btnPeripdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_per_update);
        initView();
    }

    private void initView() {
        ivBack = findViewById(R.id.iv_back);
        btnPeripdate = findViewById(R.id.btn_peripdate);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PerUpdateActivity.this, HomeActivity.class);
                intent.putExtra("id",3);
                startActivity(intent);
            }
        });
    }
}