package com.example.competedata9.news;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.competedata9.HomeActivity;
import com.example.competedata9.R;
import com.example.competedata9.adapter.NewsListAdapter;
import com.example.competedata9.api.HttpbinServices;
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

public class NewsDeatiledActivity extends AppCompatActivity {

    private NewsListBean.RowsBean rowsBean;
    private ImageView ivBack;
    private ImageView ivNewsdetailed;
    private TextView tvContent;
    private TextView tvCommentnum;
    private Button btnComment;
    private ListView listCommend;
    private NewsListAdapter newsListAdapter;
    private Retrofit retrofit;
    private HttpbinServices httpbinServices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_deatiled);
        Intent intent=getIntent();
        rowsBean=(NewsListBean.RowsBean)intent.getSerializableExtra("news");
        if(rowsBean==null){
            return;
        }
        retrofit=new Retrofit.Builder().baseUrl(Contants.WEB_URL).build();
        httpbinServices=retrofit.create(HttpbinServices.class);
        initView();
        initData();
        setData();
    }

    private void setData() {
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
    private void initData() {
        if(rowsBean==null){
            return;
        }
        tvContent.setText(rowsBean.getContent());
        tvCommentnum.setText("评论人数："+rowsBean.getCommentNum());
        Glide.with(this)
                .load(Contants.WEB_URL+rowsBean.getCover())
                .into(ivNewsdetailed);

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(NewsDeatiledActivity.this, HomeActivity.class);
                intent.putExtra("id",1);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        ivBack = findViewById(R.id.iv_back);
        ivNewsdetailed = findViewById(R.id.iv_newsdetailed);
        tvContent = findViewById(R.id.tv_content);
        tvCommentnum = findViewById(R.id.tv_commentnum);
        btnComment = findViewById(R.id.btn_comment);
        listCommend = findViewById(R.id.list_commend);
        newsListAdapter=new NewsListAdapter(NewsDeatiledActivity.this);
        listCommend.setAdapter(newsListAdapter);
    }
}