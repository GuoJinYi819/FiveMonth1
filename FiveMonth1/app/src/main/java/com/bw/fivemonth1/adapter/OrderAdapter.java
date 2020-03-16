package com.bw.fivemonth1.adapter;

import android.content.Context;

import com.bw.fivemonth1.fragment.OrderListFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * ClassName: FiveMonth1
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/14 17:00
 * @Description: 用途：完成特定功能
 */
public class OrderAdapter extends FragmentPagerAdapter {

    private List<Fragment> list = new ArrayList<>(  );
    private String[] arr = {"全部订单","待付款","待收货","待评价","已完成"};


    public OrderAdapter(@NonNull FragmentManager fm) {
        super( fm );
        list.add( OrderListFragment.newInstance( 0 ) );
        list.add( OrderListFragment.newInstance( 1 ) );
        list.add( OrderListFragment.newInstance( 2 ) );
        list.add( OrderListFragment.newInstance( 3 ) );
        list.add( OrderListFragment.newInstance( 9 ) );
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list.get( position );
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return arr[position];
    }
}
