package com.example.competedata9.news.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.competedata9.R;
import com.example.competedata9.adapter.NewsBannerAdapter;
import com.example.competedata9.adapter.NewsListAdapter;
import com.example.competedata9.api.HttpbinServices;
import com.example.competedata9.bean.NewsBannerBean;
import com.example.competedata9.bean.NewsListBean;
import com.example.competedata9.utils.Contants;
import com.example.competedata9.utils.Jsonparse;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewsTab1BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsTab1BlankFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ListView listNews;

    public NewsTab1BlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewsTab1BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewsTab1BlankFragment newInstance(String param1, String param2) {
        NewsTab1BlankFragment fragment = new NewsTab1BlankFragment();
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
    private NewsListAdapter newsListAdapter;
    private Retrofit retrofit;
    private HttpbinServices httpbinServices;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (rootview == null) {
            rootview = inflater.inflate(R.layout.fragment_news_tab1_blank, container, false);
        }
        retrofit=new Retrofit.Builder().baseUrl(Contants.WEB_URL).build();
        httpbinServices=retrofit.create(HttpbinServices.class);
        initData();
        initView();
        return rootview;
    }

    private void initData() {
        Call<ResponseBody> call=httpbinServices.getNewsList();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String res=response.body().string();
                    List<NewsListBean.RowsBean> rowsBeanList= Jsonparse.getmInstance().getNewsList(res);
                    newsListAdapter.setRowsBeanList(rowsBeanList);
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
        listNews = rootview.findViewById(R.id.list_news);
        newsListAdapter=new NewsListAdapter(getContext());
        listNews.setAdapter(newsListAdapter);
    }
}