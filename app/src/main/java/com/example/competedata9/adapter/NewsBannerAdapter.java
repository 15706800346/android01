package com.example.competedata9.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.competedata9.bean.NewsBannerBean;
import com.example.competedata9.utils.Contants;
import com.youth.banner.loader.ImageLoader;

public class NewsBannerAdapter extends ImageLoader {
    @Override
    public void displayImage(Context context, Object o, ImageView imageView) {
        NewsBannerBean.RowsBean rowsBean=(NewsBannerBean.RowsBean)o;
        Glide.with(context)
                .load(Contants.WEB_URL+rowsBean.getAdvImg())
                .into(imageView);
    }
}
