package com.gy.limguide.manager;

import com.gy.limguide.R;
import com.gy.limguide.fragment.BaseTitleFragment;

public class HomeTab3Fragment extends BaseTitleFragment {
    @Override
    protected int onSetContentView() {
        return R.layout.fragment_home_tab3;
    }

    @Override
    protected void onInitData() {

        setTitle(0,"天气预报Weather",0);

    }
}
