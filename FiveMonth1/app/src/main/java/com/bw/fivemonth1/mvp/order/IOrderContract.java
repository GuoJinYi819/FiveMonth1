package com.bw.fivemonth1.mvp.order;

import com.bw.fivemonth1.base.IBaseView;
import com.bw.fivemonth1.bean.OrderBean;

import java.util.Map;

/**
 * ClassName: FiveMonth1
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/14 15:07
 * @Description: 用途：完成特定功能
 */
public interface IOrderContract {
    interface IOrderView extends IBaseView{
        void onSuccess(OrderBean bean);
        void onFailed(String error);
    }
    interface IOrderModlue{
        void getOrder(Map<String,String> param,ModuleCallBack moduleCallBack);
        interface ModuleCallBack{
            void onSuccess(OrderBean bean);
            void onFailed(String error);
        }
    }
    interface IOrderPresenter{
        void getOrder(Map<String,String> param);
    }
}
