package com.example.competedata9.person;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.competedata9.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PersonBlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PersonBlankFragment extends Fragment implements View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView tvPerinfo;
    private TextView tvPerorder;
    private TextView tvPerfeed;
    private TextView tvPerupdate;
    private Button btnQuit;

    public PersonBlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PersonBlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PersonBlankFragment newInstance(String param1, String param2) {
        PersonBlankFragment fragment = new PersonBlankFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (rootview == null) {
            rootview = inflater.inflate(R.layout.fragment_person_blank, container, false);
        }
        initView();
        return rootview;
    }

    private void initView() {
        tvPerinfo = rootview.findViewById(R.id.tv_perinfo);
        tvPerorder = rootview.findViewById(R.id.tv_perorder);
        tvPerfeed = rootview.findViewById(R.id.tv_perfeed);
        tvPerupdate = rootview.findViewById(R.id.tv_perupdate);
        btnQuit = rootview.findViewById(R.id.btn_quit);

        tvPerinfo.setOnClickListener(this);
        tvPerorder.setOnClickListener(this);
        tvPerfeed.setOnClickListener(this);
        tvPerupdate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=null;
        switch (v.getId()){
            case R.id.tv_perinfo:
                intent=new Intent(getContext(),PerInfoActivity.class);
                break;
            case R.id.tv_perfeed:
                intent=new Intent(getContext(),PerFeedActivity.class);
                break;
            case R.id.tv_perorder:
                intent=new Intent(getContext(),PerOrderActivity.class);
                break;
            case R.id.tv_perupdate:
                intent=new Intent(getContext(),PerUpdateActivity.class);
                break;
        }
        startActivity(intent);
    }
}