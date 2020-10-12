package com.example.customrefreshlayout.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @author by chenlp
 * @date 2020/9/22
 * @describe
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragmentList;

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior, List<Fragment> fragmentList) {
        super(fm, behavior);
        mFragmentList = fragmentList;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
