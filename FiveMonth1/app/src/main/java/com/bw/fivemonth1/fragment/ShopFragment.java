package com.bw.fivemonth1.fragment;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.bw.fivemonth1.R;
import com.bw.fivemonth1.adapter.ShopAdapter;
import com.bw.fivemonth1.base.BaseFragment;
import com.bw.fivemonth1.bean.EventBean;
import com.bw.fivemonth1.bean.ShopBean;
import com.bw.fivemonth1.mvp.shop.IShopContract;
import com.bw.fivemonth1.mvp.shop.ShopPresenterImpl;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

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
public class ShopFragment extends BaseFragment<ShopPresenterImpl> implements IShopContract.IShopView {
    @BindView(R.id.expandableListView)
    ExpandableListView expandableListView;
    @BindView(R.id.checkBoxShop)
    CheckBox checkBoxShop;
    @BindView(R.id.tvContent)
    TextView tvContent;
    private Unbinder unbind;
    private ShopAdapter shopAdapter;

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_shop;
    }

    @Override
    protected void initView(View view) {
        unbind = ButterKnife.bind( this, view );
        boolean registered = EventBus.getDefault().isRegistered( this );
        if (!registered) {
            EventBus.getDefault().register( this );
        }
    }

    @Override
    protected void initListener() {
        checkBoxShop.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (shopAdapter != null) {
                    List<ShopBean.ResultBean> list = shopAdapter.getList();
                    for (int i = 0; i < list.size(); i++) {
                        ShopBean.ResultBean resultBean = list.get( i );
                        resultBean.setIsChecked( isChecked );
                        List<ShopBean.ResultBean.ShoppingCartListBean> shoppingCartList = resultBean.getShoppingCartList();
                        for (int j = 0; j < shoppingCartList.size(); j++) {
                            ShopBean.ResultBean.ShoppingCartListBean shoppingCartListBean = shoppingCartList.get( j );
                            shoppingCartListBean.setIsChecked( isChecked );
                        }
                    }
                    shopAdapter.notifyDataSetChanged();
                    countMoney( list );
                }

            }

        } );
    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void onEvnet(EventBean bean){
        if (bean != null) {
            List<ShopBean.ResultBean> list = bean.getList();
            countMoney( list );
        }

    }
    @Override
    protected void initData() {
        presenter.getShop();
    }

    @Override
    protected ShopPresenterImpl initPresenter() {
        return new ShopPresenterImpl();
    }

    @Override
    public void onSuccess(ShopBean bean) {
        if (bean != null) {
            List<ShopBean.ResultBean> result = bean.getResult();
            if (result != null) {
                shopAdapter = new ShopAdapter( result, getContext() );
                expandableListView.setAdapter( shopAdapter );

                int groupCount = shopAdapter.getGroupCount();
                for (int i = 0; i < groupCount; i++) {
                    expandableListView.expandGroup( i );
                }
            }
        }
    }

    @Override
    public void onFailed(String error) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbind != null) {
            unbind.unbind();
        }
        EventBus.getDefault().unregister( this );
    }


    //算钱
    private void countMoney(List<ShopBean.ResultBean> list){
        int sum = 0;
        double money = 0d;
        for (int i = 0; i < list.size(); i++) {
            ShopBean.ResultBean resultBean = list.get( i );
            List<ShopBean.ResultBean.ShoppingCartListBean> shoppingCartList = resultBean.getShoppingCartList();
            for (int j = 0; j < shoppingCartList.size(); j++) {
                ShopBean.ResultBean.ShoppingCartListBean shoppingCartListBean = shoppingCartList.get( j );
                boolean isChecked = shoppingCartListBean.getIsChecked();
                if (isChecked) {
                    sum += shoppingCartListBean.getCount();

                    money += shoppingCartListBean.getPrice()*shoppingCartListBean.getCount();
                }
            }
        }
        tvContent.setText( "共"+sum+"件"+"  共需"+money+"元" );
    }
}
