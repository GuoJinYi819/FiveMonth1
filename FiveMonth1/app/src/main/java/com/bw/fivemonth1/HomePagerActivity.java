package com.bw.fivemonth1;

import android.os.Bundle;

import com.bw.fivemonth1.adapter.HomeAdapter;
import com.bw.fivemonth1.base.BaseActivity;
import com.bw.fivemonth1.base.BasePresenter;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomePagerActivity extends BaseActivity {
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    private Unbinder unbind;

    @Override
    protected int initLayoutId() {
        return R.layout.activity_home_pager;
    }

    @Override
    protected void initView() {
        unbind = ButterKnife.bind( this );
        HomeAdapter homeAdapter = new HomeAdapter( getSupportFragmentManager() );
        viewPager.setAdapter( homeAdapter );
        tabLayout.setupWithViewPager( viewPager );

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbind != null) {
            unbind.unbind();
        }
    }
}
