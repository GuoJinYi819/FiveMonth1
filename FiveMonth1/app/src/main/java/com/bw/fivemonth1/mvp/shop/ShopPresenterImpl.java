package com.bw.fivemonth1.mvp.shop;

import com.bw.fivemonth1.base.BasePresenter;
import com.bw.fivemonth1.bean.ShopBean;

/**
 * ClassName: FiveMonth1
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/14 15:51
 * @Description: 用途：完成特定功能
 */
public class ShopPresenterImpl extends BasePresenter<IShopContract.IShopView> implements IShopContract.IShopPresenter {
    private ShopModuleImpl module;
    @Override
    protected void initMoudle() {
        module = new ShopModuleImpl();
    }

    @Override
    public void getShop() {
        module.getShop( new IShopContract.IShopModlue.ModuleCallBack() {
            @Override
            public void onSuccess(ShopBean bean) {
                baseView.onSuccess( bean );
            }

            @Override
            public void onFailed(String error) {
                baseView.onFailed( error );
            }
        } );
    }
}
