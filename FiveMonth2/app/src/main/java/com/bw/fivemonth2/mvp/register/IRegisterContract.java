package com.bw.fivemonth2.mvp.register;

import com.bw.fivemonth2.base.IBaseView;
import com.bw.fivemonth2.bean.RegisterBean;

import java.util.Map;

/**
 * ClassName: FiveMonth2
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/16 9:10
 * @Description: 用途：完成特定功能
 */
public interface IRegisterContract {
    interface IRegisterView extends IBaseView{
        void onSuccess(RegisterBean bean);
        void onFailed(String error);
    }
    interface IRegisterModule{
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
