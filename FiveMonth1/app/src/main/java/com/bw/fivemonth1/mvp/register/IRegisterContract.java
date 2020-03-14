package com.bw.fivemonth1.mvp.register;

import com.bw.fivemonth1.base.IBaseView;
import com.bw.fivemonth1.bean.RegisterBean;

import java.util.Map;

/**
 * ClassName: FiveMonth1
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/14 15:07
 * @Description: 用途：完成特定功能
 */
public interface IRegisterContract {
    interface IRegisterView extends IBaseView{
        void onSuccess(RegisterBean bean);
        void onFailed(String error);
    }
    interface IRegisterModlue{
        void registerUser(Map<String,String> param,ModuleCallBack moduleCallBack);
        interface ModuleCallBack{
            void onSuccess(RegisterBean bean);
            void onFailed(String error);
        }
    }
    interface IRegisterPresenter{
        void registerUser(Map<String,String> param);
    }
}
