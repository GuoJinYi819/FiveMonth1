package com.bw.fivemonth1.fragment;

import android.view.View;

import com.bw.fivemonth1.R;
import com.bw.fivemonth1.adapter.OrderAdapter;
import com.bw.fivemonth1.base.BaseFragment;
import com.bw.fivemonth1.base.BasePresenter;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * ClassName: FiveMonth1
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/14 15:32
 * @Description: 用途：完成特定功能
 */
public class OrderFragment extends BaseFragment {
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    private Unbinder unbind;

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_order;
    }

    @Override
    protected void initView(View view) {
        unbind = ButterKnife.bind( this, view );
        OrderAdapter orderAdapter = new OrderAdapter( getChildFragmentManager() );
        viewPager.setAdapter( orderAdapter );
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
    public void onDestroy() {
        super.onDestroy();
        if (unbind != null) {
            unbind.unbind();
        }
    }
}
