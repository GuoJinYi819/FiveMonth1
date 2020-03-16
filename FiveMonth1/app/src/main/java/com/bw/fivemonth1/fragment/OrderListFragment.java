package com.bw.fivemonth1.fragment;

import android.os.Bundle;
import android.view.View;

import com.bw.fivemonth1.R;
import com.bw.fivemonth1.adapter.OrderGroupAdapter;
import com.bw.fivemonth1.base.BaseFragment;
import com.bw.fivemonth1.base.BasePresenter;
import com.bw.fivemonth1.bean.OrderBean;
import com.bw.fivemonth1.mvp.order.IOrderContract;
import com.bw.fivemonth1.mvp.order.OrderPresenterImpl;

import java.util.HashMap;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * ClassName: FiveMonth1
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/14 17:01
 * @Description: 用途：完成特定功能
 */
public class OrderListFragment extends BaseFragment<OrderPresenterImpl>implements IOrderContract.IOrderView {
    @BindView(R.id.recyclerGroup)
    RecyclerView recyclerGroup;
    private Unbinder unbind;

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_orderlist;
    }

    @Override
    protected void initView(View view) {
        unbind = ButterKnife.bind( this, view );
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager( getContext() );
        linearLayoutManager.setOrientation( RecyclerView.VERTICAL );
        recyclerGroup.setLayoutManager( linearLayoutManager );
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

        Bundle arguments = getArguments();
        int status = arguments.getInt( "status" );
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put( "status",String.valueOf( status ) );
        hashMap.put( "page","1");
        hashMap.put( "count","10");
        presenter.getOrder(hashMap);

    }

    public static OrderListFragment newInstance(int status) {

        Bundle args = new Bundle();
        args.putInt( "status", status );
        OrderListFragment fragment = new OrderListFragment();
        fragment.setArguments( args );
        return fragment;
    }

    @Override
    protected OrderPresenterImpl initPresenter() {
        return new OrderPresenterImpl();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbind != null) {
            unbind.unbind();
        }
    }

    @Override
    public void onSuccess(OrderBean bean) {
        if (bean != null) {
            List<OrderBean.OrderListBean> orderList = bean.getOrderList();
            if (orderList != null) {
                OrderGroupAdapter orderGroupAdapter = new OrderGroupAdapter( orderList, getContext() );
                recyclerGroup.setAdapter( orderGroupAdapter );

            }
        }
    }

    @Override
    public void onFailed(String error) {

    }
}
