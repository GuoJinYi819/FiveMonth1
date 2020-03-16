package com.bw.fivemonth1.mvp.shop;

import com.bw.fivemonth1.base.IBaseView;
import com.bw.fivemonth1.bean.LoginBean;
import com.bw.fivemonth1.bean.ShopBean;

import java.util.Map;

/**
 * ClassName: FiveMonth1
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/14 15:07
 * @Description: 用途：完成特定功能
 */
public interface IShopContract {
    interface IShopView extends IBaseView{
        void onSuccess(ShopBean bean);
        void onFailed(String error);
    }
    interface IShopModlue{
        void getShop( ModuleCallBack moduleCallBack);
        interface ModuleCallBack{
            void onSuccess(ShopBean bean);
            void onFailed(String error);
        }
    }
    interface IShopPresenter{
        void getShop();
    }
}
