package com.example.competedata9;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static List<Integer> slist = new ArrayList<>();

    static {
        slist.add(R.drawable.sky);
        slist.add(R.drawable.self);
        slist.add(R.drawable.please);
        slist.add(R.drawable.hi);
        slist.add(R.drawable.cat);
    }

    private Banner bannerLead;
    private LinearLayout linearDialog;
    private LinearLayout linearGetintohome;
    private Button btn_dialog,btn_getintohome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initBanner();
        initBtn();
    }


    private void initBanner() {
        bannerLead.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object o, ImageView imageView) {
                Glide.with(context)
                        .load(o)
                        .into(imageView);
            }
        });
        bannerLead.setImages(slist);
        bannerLead.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==4){
                    initBtn();
                    linearDialog.addView(btn_dialog);
                    linearGetintohome.addView(btn_getintohome);
                }else {
                    linearDialog.removeAllViews();
                    linearGetintohome.removeAllViews();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        bannerLead.start();
        bannerLead.stopAutoPlay();
    }

    private void initBtn() {
        btn_dialog=new Button(this);
        btn_getintohome=new Button(this);
        btn_dialog.setText("网络设置");
        btn_dialog.setTextSize(20);
        btn_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IPDialog ipDialog=new IPDialog(MainActivity.this);
                ipDialog.dismiss();
                ipDialog.show();
            }
        });

        btn_getintohome.setTextSize(20);
        btn_getintohome.setText("进入主页");
        btn_getintohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                intent.putExtra("id",0);
                startActivity(intent);
            }
        });
    }
    private void initView() {
        bannerLead = findViewById(R.id.banner_lead);
        linearDialog = findViewById(R.id.linear_dialog);
        linearGetintohome = findViewById(R.id.linear_getintohome);
    }
}