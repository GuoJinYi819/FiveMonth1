package com.bw.fivemonth2.mvp.login;

import com.bw.fivemonth2.base.IBaseView;
import com.bw.fivemonth2.bean.LoginBean;

import java.util.Map;

/**
 * ClassName: FiveMonth2
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/16 8:58
 * @Description: 用途：完成特定功能
 */
public interface ILoginContract {
    interface ILoginView extends IBaseView{
        void onSuccess(LoginBean bean);
        void onFailed(String error);
    }
    interface ILoginModule{
        void loginUser(Map<String,String> param,ModuleCallBack moduleCallBack);
        interface ModuleCallBack{
            void onSuccess(LoginBean bean);
            void onFailed(String error);
        }
    }
    interface ILoginPresenter{
        void loginUser(Map<String,String> param);
    }
}
