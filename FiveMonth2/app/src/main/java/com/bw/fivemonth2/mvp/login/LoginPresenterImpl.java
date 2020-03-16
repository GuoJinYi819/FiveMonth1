package com.bw.fivemonth2.mvp.login;

import com.bw.fivemonth2.base.BasePresenter;
import com.bw.fivemonth2.bean.LoginBean;

import java.util.Map;

/**
 * ClassName: FiveMonth2
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/16 9:02
 * @Description: 用途：完成特定功能
 */
public class LoginPresenterImpl extends BasePresenter<ILoginContract.ILoginView> implements ILoginContract.ILoginPresenter {
    private LoginMouduleImpl moudule;
    @Override
    protected void initModule() {
        moudule = new LoginMouduleImpl();
    }

    @Override
    public void loginUser(Map<String, String> param) {
        moudule.loginUser( param, new ILoginContract.ILoginModule.ModuleCallBack() {
            @Override
            public void onSuccess(LoginBean bean) {
                baseView.onSuccess( bean );
            }

            @Override
            public void onFailed(String error) {
                baseView.onFailed( error );
            }
        } );
    }
}
