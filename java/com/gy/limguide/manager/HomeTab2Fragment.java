package com.gy.limguide.manager;



import android.support.v4.view.ViewPager;

import com.gy.limguide.R;
import com.gy.limguide.fragment.BaseTitleFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import butterknife.BindView;

public class HomeTab2Fragment extends BaseTitleFragment {

    @BindView(R.id.tabLayout)
    SmartTabLayout smartTabLayout;

    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    private FragmentPagerItemAdapter mTabAdapter;
    @Override
    protected int onSetContentView() {
        return R.layout.fragment_home_tab2;
    }

    @Override
    protected void onInitData() {

        setTitle(0,"旅行攻略TravelTips",0);

        mTabAdapter = new FragmentPagerItemAdapter(getActivity().getSupportFragmentManager(), FragmentPagerItems.with(mContext)
                .add("旅游攻略TravelTips", GuideOneFragment.class)
                .add("租房咨询Rental House", GuideTwoFragment.class)
                .add("签证问答Visa Q&A", GuideThreeFragment.class)
                .add("二手市场Flea Markets", GuideFourFragment.class)
                .create());
        mViewPager.setAdapter(mTabAdapter);
        smartTabLayout.setViewPager(mViewPager);
    }


}
