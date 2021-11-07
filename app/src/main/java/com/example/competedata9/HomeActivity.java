package com.example.competedata9;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.competedata9.adapter.MyFragmentAdapter;
import com.example.competedata9.home.HomeBlankFragment;
import com.example.competedata9.news.NewsBlankFragment;
import com.example.competedata9.party.PartyBlankFragment;
import com.example.competedata9.person.PersonBlankFragment;
import com.example.competedata9.services.ServicesBlankFragment;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewPager2 viewpagerHome;
    private LinearLayout linearHome;
    private ImageView ivHome;
    private LinearLayout linearNews;
    private ImageView ivNews;
    private LinearLayout linearParty;
    private ImageView ivParty;
    private LinearLayout linearPerson;
    private ImageView ivPerson;
    private LinearLayout linearServices;
    private ImageView ivServices,iv_current;
    private MyFragmentAdapter myFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        initPager();
        viewpagerHome.setOffscreenPageLimit(5);
        initId();
    }

    private void initId() {
        Intent intent=getIntent();
        int id=intent.getIntExtra("id",0);
        switch (id){
            case 0:
                viewpagerHome.setCurrentItem(0);
                break;
            case 1:
                viewpagerHome.setCurrentItem(1);
                break;
            case 2:
                viewpagerHome.setCurrentItem(2);
                break;
            case 3:
                viewpagerHome.setCurrentItem(3);
                break;
            case 4:
                viewpagerHome.setCurrentItem(4);
                break;
        }
    }

    private void initPager() {
        viewpagerHome = findViewById(R.id.viewpager_home);
        ArrayList<Fragment> fragments=new ArrayList<>();
        fragments.add(HomeBlankFragment.newInstance("1","2"));
        fragments.add(NewsBlankFragment.newInstance("1","2"));
        fragments.add(PartyBlankFragment.newInstance("1","2"));
        fragments.add(PersonBlankFragment.newInstance("1","2"));
        fragments.add(ServicesBlankFragment.newInstance("1","2"));
        myFragmentAdapter=new MyFragmentAdapter(getSupportFragmentManager(),getLifecycle(),fragments);
        viewpagerHome.setAdapter(myFragmentAdapter);
        viewpagerHome.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                changeTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    private void changeTab(int position) {
        iv_current.setSelected(false);
        switch (position){
            case R.id.linear_home:
                viewpagerHome.setCurrentItem(0);
            case 0:
                iv_current=ivHome;
                ivHome.setSelected(true);
                break;
            case R.id.linear_news:
                viewpagerHome.setCurrentItem(1);
            case 1:
                iv_current=ivNews;
                ivNews.setSelected(true);
                break;
            case R.id.linear_party:
                viewpagerHome.setCurrentItem(2);
            case 2:
                iv_current=ivParty;
                ivParty.setSelected(true);
                break;
            case R.id.linear_person:
                viewpagerHome.setCurrentItem(3);
            case 3:
                iv_current=ivPerson;
                ivPerson.setSelected(true);
                break;
            case R.id.linear_services:
                viewpagerHome.setCurrentItem(4);
            case 4:
                iv_current=ivServices;
                ivServices.setSelected(true);
                break;
        }
    }

    private void initView() {

        linearHome = findViewById(R.id.linear_home);
        ivHome = findViewById(R.id.iv_home);
        linearNews = findViewById(R.id.linear_news);
        ivNews = findViewById(R.id.iv_news);
        linearParty = findViewById(R.id.linear_party);
        ivParty = findViewById(R.id.iv_party);
        linearPerson = findViewById(R.id.linear_person);
        ivPerson = findViewById(R.id.iv_person);
        linearServices = findViewById(R.id.linear_services);
        ivServices = findViewById(R.id.iv_services);

        iv_current=ivHome;
        ivHome.setSelected(true);

        linearHome.setOnClickListener(this);
        linearNews.setOnClickListener(this);
        linearParty.setOnClickListener(this);
        linearPerson.setOnClickListener(this);
        linearServices.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        changeTab(v.getId());
    }
}