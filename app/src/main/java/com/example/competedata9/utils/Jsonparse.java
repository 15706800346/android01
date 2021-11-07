package com.example.competedata9.utils;

import com.example.competedata9.bean.HomeBannerBean;
import com.example.competedata9.bean.NewsBannerBean;
import com.example.competedata9.bean.NewsListBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Jsonparse {
    private static Jsonparse mInstance=null;
    public Jsonparse() {
    }

    public static Jsonparse getmInstance() {
        if(mInstance==null){
            mInstance=new Jsonparse();
        }
        return mInstance;
    }

    public List<NewsBannerBean.RowsBean> getNewsBanner(String json){
        Gson gson=new Gson();
        Type type=new TypeToken<List<NewsBannerBean.RowsBean>>(){}.getType();
        List<NewsBannerBean.RowsBean> rowsBeanList=new ArrayList<>();
        try {
            JSONObject jsonObject=new JSONObject(json);
            JSONArray jsonArray=jsonObject.getJSONArray("rows");
            rowsBeanList=gson.fromJson(String.valueOf(jsonArray),type);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return rowsBeanList;
    }
    public List<NewsListBean.RowsBean> getNewsList(String json){
        Gson gson=new Gson();
        Type type=new TypeToken<List<NewsListBean.RowsBean>>(){}.getType();
        List<NewsListBean.RowsBean> rowsBeanList=new ArrayList<>();
        try {
            JSONObject jsonObject=new JSONObject(json);
            JSONArray jsonArray=jsonObject.getJSONArray("rows");
            rowsBeanList=gson.fromJson(String.valueOf(jsonArray),type);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return rowsBeanList;
    }
    public List<HomeBannerBean.RowsBean> getHomeBanner(String json){
        Gson gson=new Gson();
        Type type=new TypeToken<List<HomeBannerBean.RowsBean>>(){}.getType();
        List<HomeBannerBean.RowsBean> rowsBeanList=new ArrayList<>();
        try {
            JSONObject jsonObject=new JSONObject(json);
            JSONArray jsonArray=jsonObject.getJSONArray("rows");
            rowsBeanList=gson.fromJson(String.valueOf(jsonArray),type);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return rowsBeanList;
    }
}
