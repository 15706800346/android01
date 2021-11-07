package com.example.competedata9.party;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.competedata9.R;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PartyBlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PartyBlankFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private SearchView searchHome;
    private Banner bannerParty;
    private Button btnParty;

    public PartyBlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PartyBlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PartyBlankFragment newInstance(String param1, String param2) {
        PartyBlankFragment fragment = new PartyBlankFragment();
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
    private static List<Integer> slist = new ArrayList<>();

    static {
        slist.add(R.drawable.w1);
        slist.add(R.drawable.w2);
        slist.add(R.drawable.w3);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (rootview == null) {
            rootview = inflater.inflate(R.layout.fragment_party_blank, container, false);
        }
        initView();
        initBanner();
        return rootview;
    }

    private void initBanner() {
        bannerParty.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object o, ImageView imageView) {
                Glide.with(context)
                        .load(o)
                        .into(imageView);
            }
        });
        bannerParty.setImages(slist);
        bannerParty.start();
    }

    private void initView() {
        searchHome = rootview.findViewById(R.id.search_home);
        bannerParty = rootview.findViewById(R.id.banner_party);
        btnParty = rootview.findViewById(R.id.btn_party);
    }
}