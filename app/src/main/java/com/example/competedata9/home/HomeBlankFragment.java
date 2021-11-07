package com.example.competedata9.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.competedata9.HomeActivity;
import com.example.competedata9.R;
import com.example.competedata9.adapter.HomeBannerAdapter;
import com.example.competedata9.adapter.MyFragmentAdapter;
import com.example.competedata9.adapter.NewsBannerAdapter;
import com.example.competedata9.api.HttpbinServices;
import com.example.competedata9.bean.HomeBannerBean;
import com.example.competedata9.bean.NewsBannerBean;
import com.example.competedata9.news.fragment.NewsTab1BlankFragment;
import com.example.competedata9.news.fragment.NewsTab2BlankFragment;
import com.example.competedata9.news.fragment.NewsTab3BlankFragment;
import com.example.competedata9.news.fragment.NewsTab4BlankFragment;
import com.example.competedata9.news.fragment.NewsTab5BlankFragment;
import com.example.competedata9.news.fragment.NewsTab6BlankFragment;
import com.example.competedata9.utils.Contants;
import com.example.competedata9.utils.Jsonparse;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeBlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeBlankFragment extends Fragment implements View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private SearchView searchHome;
    private Banner bannerHome;
    private LinearLayout linearPark;
    private LinearLayout linearMetro;
    private LinearLayout linearBus;
    private LinearLayout linearHospital;
    private LinearLayout linearCar;
    private LinearLayout linearMoney;
    private LinearLayout linearHungry;
    private LinearLayout linearFindhouse;
    private LinearLayout linearMovie;
    private LinearLayout linearMoreservices;
    private TextView tvNewsClass1;
    private TextView tvNewsClass2;
    private TextView tvNewsClass3;
    private TextView tvNewsClass4;
    private TextView tvNewsClass5;
    private TextView tvNewsClass6,tv_current;
    private ViewPager2 viewHome;

    public HomeBlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeBlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeBlankFragment newInstance(String param1, String param2) {
        HomeBlankFragment fragment = new HomeBlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private View rootview = null;
    private Retrofit retrofit;
    private HttpbinServices httpbinServices;
    private MyFragmentAdapter myFragmentAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (rootview == null) {
            rootview = inflater.inflate(R.layout.fragment_home_blank, container, false);
        }
        retrofit=new Retrofit.Builder().baseUrl(Contants.WEB_URL).build();
        httpbinServices=retrofit.create(HttpbinServices.class);
        initView();
        initBanner();
        initPager();
        initJump();
        return rootview;
    }

    private void initJump() {
        searchHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),SearcheActivity.class);
                startActivity(intent);
            }
        });
        linearMoreservices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), HomeActivity.class);
                intent.putExtra("id",4);
                startActivity(intent);
            }
        });

    }

    private void initPager() {
        viewHome = rootview.findViewById(R.id.view_home);
        ArrayList<Fragment> fragments=new ArrayList<>();
        fragments.add(NewsTab1BlankFragment.newInstance("1","2"));
        fragments.add(NewsTab2BlankFragment.newInstance("1","2"));
        fragments.add(NewsTab3BlankFragment.newInstance("1","2"));
        fragments.add(NewsTab4BlankFragment.newInstance("1","2"));
        fragments.add(NewsTab5BlankFragment.newInstance("1","2"));
        fragments.add(NewsTab6BlankFragment.newInstance("1","2"));
        myFragmentAdapter=new MyFragmentAdapter(getChildFragmentManager(),getLifecycle(),fragments);
        viewHome.setAdapter(myFragmentAdapter);
        viewHome.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
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
        tv_current.setSelected(false);
        switch (position){
            case R.id.tv_news_class1:
                viewHome.setCurrentItem(0);
            case 0:
                tv_current=tvNewsClass1;
                tvNewsClass1.setSelected(true);
                break;
            case R.id.tv_news_class2:
                viewHome.setCurrentItem(1);
            case 1:
                tv_current=tvNewsClass2;
                tvNewsClass2.setSelected(true);
                break;
            case R.id.tv_news_class3:
                viewHome.setCurrentItem(2);
            case 2:
                tv_current=tvNewsClass3;
                tvNewsClass3.setSelected(true);
                break;
            case R.id.tv_news_class4:
                viewHome.setCurrentItem(3);
            case 3:
                tv_current=tvNewsClass4;
                tvNewsClass4.setSelected(true);
                break;
            case R.id.tv_news_class5:
                viewHome.setCurrentItem(4);
            case 4:
                tv_current=tvNewsClass5;
                tvNewsClass5.setSelected(true);
                break;
            case R.id.tv_news_class6:
                viewHome.setCurrentItem(5);
            case 5:
                tv_current=tvNewsClass6;
                tvNewsClass6.setSelected(true);
                break;
        }
    }
    private void initBanner() {
        bannerHome = rootview.findViewById(R.id.banner_home);
        Call<ResponseBody> call=httpbinServices.getHomeBanner();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String res=response.body().string();
                    List<HomeBannerBean.RowsBean> rowsBeanList= Jsonparse.getmInstance().getHomeBanner(res);
                    bannerHome.setImageLoader(new HomeBannerAdapter());
                    bannerHome.setImages(rowsBeanList);
                    bannerHome.setOnBannerListener(new OnBannerListener() {
                        @Override
                        public void OnBannerClick(int i) {
                            Intent intent=null;
                            if(i==0){
                                intent=new Intent(getContext(),HomeSkip1Activity.class);
                            }else if(i==1){
                                intent=new Intent(getContext(),HomeSkip2Activity.class);
                            }else if(i==2){
                                intent=new Intent(getContext(),HomeSkip3Activity.class);
                            }
                            startActivity(intent);
                        }
                    });
                    bannerHome.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable throwable) {

            }
        });
    }

    private void initView() {
        searchHome = rootview.findViewById(R.id.search_home);

        linearPark = rootview.findViewById(R.id.linear_park);
        linearMetro = rootview.findViewById(R.id.linear_metro);
        linearBus = rootview.findViewById(R.id.linear_bus);
        linearHospital = rootview.findViewById(R.id.linear_hospital);
        linearCar = rootview.findViewById(R.id.linear_car);
        linearMoney = rootview.findViewById(R.id.linear_money);
        linearHungry = rootview.findViewById(R.id.linear_hungry);
        linearFindhouse = rootview.findViewById(R.id.linear_findhouse);
        linearMovie = rootview.findViewById(R.id.linear_movie);
        linearMoreservices = rootview.findViewById(R.id.linear_moreservices);
        tvNewsClass1 = rootview.findViewById(R.id.tv_news_class1);
        tvNewsClass2 = rootview.findViewById(R.id.tv_news_class2);
        tvNewsClass3 = rootview.findViewById(R.id.tv_news_class3);
        tvNewsClass4 = rootview.findViewById(R.id.tv_news_class4);
        tvNewsClass5 = rootview.findViewById(R.id.tv_news_class5);
        tvNewsClass6 = rootview.findViewById(R.id.tv_news_class6);


        tvNewsClass1.setOnClickListener(this);
        tvNewsClass2.setOnClickListener(this);
        tvNewsClass3.setOnClickListener(this);
        tvNewsClass4.setOnClickListener(this);
        tvNewsClass5.setOnClickListener(this);
        tvNewsClass6.setOnClickListener(this);

        tv_current=tvNewsClass1;
        tvNewsClass1.setSelected(true);
    }

    @Override
    public void onClick(View v) {
        changeTab(v.getId());
    }
}