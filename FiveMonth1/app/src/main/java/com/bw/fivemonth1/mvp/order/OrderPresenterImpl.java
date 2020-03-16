package com.bw.fivemonth1.mvp.order;

import com.bw.fivemonth1.base.BasePresenter;
import com.bw.fivemonth1.bean.OrderBean;

import java.util.Map;

/**
 * ClassName: FiveMonth1
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/14 17:19
 * @Description: 用途：完成特定功能
 */
public class OrderPresenterImpl extends BasePresenter<IOrderContract.IOrderView> implements IOrderContract.IOrderPresenter {
    private OrderModuleImpl module;
    @Override
    protected void initMoudle() {
        module = new OrderModuleImpl();
    }

    @Override
    public void getOrder(Map<String,String> param) {
        module.getOrder(param, new IOrderContract.IOrderModlue.ModuleCallBack() {
            @Override
            public void onSuccess(OrderBean bean) {
                baseView.onSuccess( bean );
            }

            @Override
            public void onFailed(String error) {
                baseView.onFailed( error );
            }
        } );
    }
}
