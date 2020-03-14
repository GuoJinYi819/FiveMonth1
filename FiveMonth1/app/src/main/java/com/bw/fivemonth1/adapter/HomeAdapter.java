package com.bw.fivemonth1.adapter;

import com.bw.fivemonth1.fragment.OrderFragment;
import com.bw.fivemonth1.fragment.ShopFragment;

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
 * @version 创建时间：2020/3/14 15:31
 * @Description: 用途：完成特定功能
 */
public class HomeAdapter extends FragmentPagerAdapter {
    private List<Fragment> list = new ArrayList<>(  );
    private String[] arr = {"购物车","订单业务"};
    public HomeAdapter(@NonNull FragmentManager fm) {
        super( fm );
        list.add( new ShopFragment() );
        list.add( new OrderFragment() );
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
