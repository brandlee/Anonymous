package com.brandlee.anonymous.common.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class CommonPagerAdapter extends FragmentPagerAdapter {

    protected PagerManager pagerManager;

    public CommonPagerAdapter(FragmentManager fm, PagerManager pagerManager) {
        super(fm);
        this.pagerManager = pagerManager;
    }

    @Override
    public Fragment getItem(int position) {
        return pagerManager.getItem(position);
    }

    @Override
    public int getCount() {
        return pagerManager.getFragmentCount();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(pagerManager.hasTitles()){
            return pagerManager.getTitle(position);
        }
        return super.getPageTitle(position);
    }
}
