package com.gy.limguide.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.gy.limguide.app.MyApplication;

import butterknife.ButterKnife;

/**
 * Created by algorithm on 2017/10/25.
 */

public abstract class BaseFragment extends Fragment implements View.OnClickListener {

    protected static String TAG = "BaseFragment";

    public MyApplication mApplication;
    protected Activity mContext;
    protected View mRootView;// Fragment的View

    protected boolean isVisible;
    protected boolean isPrepare;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        TAG = this.getClass().getSimpleName();
        mContext = (Activity) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (mRootView == null) {
            mRootView = inflater.inflate(onSetContentView(), container, false);
        } else {
        }
        ButterKnife.bind(this, mRootView);
        isPrepare=true;
        onInitdata(savedInstanceState);
        onInitData();

        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }



    protected abstract int onSetContentView();

    protected abstract void onInitData();

    @Override
    public void onClick(View v) {

    }
    public void loadDate(){};

    public void onInitdata(Bundle savedInstanceState){

    }
}
