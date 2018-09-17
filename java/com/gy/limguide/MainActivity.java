package com.gy.limguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.gy.limguide.manager.AlFragmentManager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    @BindView(R.id.radioGroup)
    RadioGroup mRadioGroup;


    private AlFragmentManager mAlFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mAlFragmentManager = AlFragmentManager.getInstance(this, R.id.container);
        mAlFragmentManager.showFragment(0);
        mRadioGroup.setOnCheckedChangeListener(this);
    }



    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        switch (checkedId) {
            case R.id.homeTab1:
                mAlFragmentManager.showFragment(0);
                break;

            case R.id.homeTab2:
                mAlFragmentManager.showFragment(1);
                break;

            case R.id.homeTab3:
                mAlFragmentManager.showFragment(2);
                break;

            case R.id.homeTab4:
                mAlFragmentManager.showFragment(3);
                break;
        }
    }
}
