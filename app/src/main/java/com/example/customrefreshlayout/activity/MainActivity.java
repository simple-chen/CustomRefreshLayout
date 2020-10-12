package com.example.customrefreshlayout.activity;

import android.os.Bundle;
import android.view.KeyEvent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.customrefreshlayout.R;
import com.example.customrefreshlayout.adapter.ViewPagerAdapter;
import com.example.customrefreshlayout.fragment.RecyclerViewFragment;
import com.example.customrefreshlayout.fragment.ScrollViewFragment;
import com.example.customrefreshlayout.fragment.WebViewFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Fragment> mFragmentList = new ArrayList<>();
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }


    private void initView() {
        mViewPager = findViewById(R.id.view_pager);
        mFragmentList.add(new WebViewFragment());
        mFragmentList.add(new RecyclerViewFragment(this));
        mFragmentList.add(new ScrollViewFragment());
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), 1, mFragmentList);
        mViewPager.setAdapter(viewPagerAdapter);
    }

}
