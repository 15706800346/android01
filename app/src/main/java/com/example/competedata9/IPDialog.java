package com.example.competedata9;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

public class IPDialog extends AlertDialog {
    private Button btnIp;

    protected IPDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_layout);
        initView();
    }

    private void initView() {
        btnIp = findViewById(R.id.btn_ip);
        btnIp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"保存成功",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
