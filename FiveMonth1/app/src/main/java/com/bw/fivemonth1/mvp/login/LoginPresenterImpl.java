package com.bw.fivemonth1.mvp.login;

import com.bw.fivemonth1.base.BasePresenter;
import com.bw.fivemonth1.bean.LoginBean;

import java.util.Map;

/**
 * ClassName: FiveMonth1
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/14 15:22
 * @Description: 用途：完成特定功能
 */
public class LoginPresenterImpl extends BasePresenter<ILoginContract.ILoginView> implements ILoginContract.ILoginPresenter {
    private LoginMouduleImpl moudule;
    @Override
    protected void initMoudle() {
        moudule  = new LoginMouduleImpl();

    }

    @Override
    public void loginUser(Map<String, String> param) {
        moudule.loginUser( param, new ILoginContract.ILoginModlue.ModuleCallBack() {
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
