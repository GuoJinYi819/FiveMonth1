package com.bw.fivemonth1.mvp.register;

import com.bw.fivemonth1.base.BasePresenter;
import com.bw.fivemonth1.bean.RegisterBean;

import java.util.Map;

/**
 * ClassName: FiveMonth1
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/14 15:11
 * @Description: 用途：完成特定功能
 */
public class RegisterPresenterImpl extends BasePresenter<IRegisterContract.IRegisterView> implements IRegisterContract.IRegisterPresenter {
    private RegisterModuleImpl module;
    @Override
    protected void initMoudle() {
        module = new RegisterModuleImpl();
    }

    @Override
    public void registerUser(Map<String, String> param) {
        module.registerUser( param, new IRegisterContract.IRegisterModlue.ModuleCallBack() {
            @Override
            public void onSuccess(RegisterBean bean) {
                baseView.onSuccess( bean );
            }

            @Override
            public void onFailed(String error) {
                baseView.onFailed( error );
            }
        } );
    }
}
