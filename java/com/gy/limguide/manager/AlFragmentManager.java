package com.gy.limguide.manager;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;



import java.util.ArrayList;
import java.util.List;

/**
 * Created by algorithm on 2017/11/6.
 *
 * Activity 对 Fragment控制的FragmentManager
 *
 */

public class AlFragmentManager {

    private List<Fragment> mFragments;

    private static AlFragmentManager instance;

    private FragmentManager mFragmentManager;
    private int mContainerID;

    public static AlFragmentManager getInstance(FragmentActivity activity, @IdRes int containerID) {

        if (instance == null) {
            instance = new AlFragmentManager(activity, containerID);
        }

        return instance;
    }

    /**
     * @param activity
     * @param containerID Activity布局添加Fragment的容器
     */
    private AlFragmentManager(FragmentActivity activity, int containerID) {

        mFragmentManager = activity.getSupportFragmentManager();
        mContainerID = containerID;

        initFragments();
    }

    private void initFragments() {

        mFragments = new ArrayList<>();
        mFragments.add(new HomeTab1Fragment());
        //mFragments.add(new HomeTab2FragmentActivity());
        mFragments.add(new HomeTab2Fragment());
        mFragments.add(new HomeTab3Fragment());
        mFragments.add(new HomeTab4Fragment());

        FragmentTransaction transaction = mFragmentManager.beginTransaction();

        for (Fragment fragment : mFragments) {

            transaction.add(mContainerID, fragment);
        }
        transaction.commitAllowingStateLoss();
    }

    private void hideFragments() {

        FragmentTransaction transaction = mFragmentManager.beginTransaction();

        for (Fragment fragment : mFragments) {

            if (fragment != null) {
                transaction.hide(fragment);
            }
        }

        transaction.commitAllowingStateLoss();
    }

    public void showFragment(int position) {

        hideFragments();

        Fragment fragment = mFragments.get(position);
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.show(fragment);
        transaction.commitAllowingStateLoss();
    }

    /**
     * 清楚所有的Fragment
     */
    public void clear() {

        FragmentTransaction transaction = mFragmentManager.beginTransaction();

        for (Fragment fragment : mFragments) {
            transaction.remove(fragment);
        }
        transaction.commitAllowingStateLoss();
    }

    public static void onDestroy() {
        instance = null;
    }
}
