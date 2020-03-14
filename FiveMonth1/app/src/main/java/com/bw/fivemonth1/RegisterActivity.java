package com.bw.fivemonth1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.bw.fivemonth1.base.BaseActivity;
import com.bw.fivemonth1.bean.RegisterBean;
import com.bw.fivemonth1.mvp.register.IRegisterContract;
import com.bw.fivemonth1.mvp.register.RegisterPresenterImpl;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class RegisterActivity extends BaseActivity<RegisterPresenterImpl> implements IRegisterContract.IRegisterView {
    @BindView(R.id.editPhone)
    EditText editPhone;
    @BindView(R.id.editPwd)
    EditText editPwd;
    @BindView(R.id.btnRegister)
    Button btnRegister;
    private Unbinder unbind;

    @Override
    protected int initLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        unbind = ButterKnife.bind( this );
    }

    @OnClick(R.id.btnRegister)
    public void onViewClicked() {
        String phone = editPhone.getText().toString().trim();
        String pwd = editPwd.getText().toString().trim();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put( "phone",phone );
        hashMap.put( "pwd",pwd );
        presenter.registerUser( hashMap );
    }
    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected RegisterPresenterImpl initPresenter() {
        return new RegisterPresenterImpl();
    }

    @Override
    public void onSuccess(RegisterBean bean) {
        if (bean != null) {
            String message = bean.getMessage();
            if (message.contains( "注册成功" )) {
                String phone = editPhone.getText().toString().trim();
                String pwd = editPwd.getText().toString().trim();
                Intent intent = new Intent();
                intent.putExtra( "phone", phone);
                intent.putExtra( "pwd",pwd );
                setResult( 100,intent );
                finish();
            }
        }
    }

    @Override
    public void onFailed(String error) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbind != null) {
            unbind.unbind();
        }
    }
}
