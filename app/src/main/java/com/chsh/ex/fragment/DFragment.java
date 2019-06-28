package com.chsh.ex.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.chsh.ex.R;
import com.chsh.ex.Test2Activity;
import com.chsh.library.swipebacklayout.BGASwipeBackHelper;

/**
 * Created by Jue on 2018/6/2.
 */

public class DFragment extends android.support.v4.app.Fragment{

    private View view ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_d, container,false);
        initView();
        
        return view;
    }

    private void initView() {
        view.findViewById(R.id.tv_d).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               getActivity().startActivity(new Intent(getActivity(),Test2Activity.class));
            }
        });

    }
    //提示消息
    public void showToast(String str) {
        Toast.makeText(getContext(), str, Toast.LENGTH_SHORT).show();
    }


}
