package com.bw.fivemonth2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.fivemonth2.base.BaseActivity;
import com.bw.fivemonth2.bean.LoginBean;
import com.bw.fivemonth2.mvp.login.ILoginContract;
import com.bw.fivemonth2.mvp.login.LoginPresenterImpl;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends BaseActivity<LoginPresenterImpl> implements ILoginContract.ILoginView {
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.pwd)
    EditText pwd;
    @BindView(R.id.button)
    Button button;
    private Unbinder unbind;

    @Override
    protected int initLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        unbind = ButterKnife.bind( this );
    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        String phone = this.phone.getText().toString().trim();
        String pwd = this.pwd.getText().toString().trim();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put( "phone",phone );
        hashMap.put( "pwd",pwd );
        presenter.loginUser( hashMap );
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected LoginPresenterImpl initPresenter() {
        return new LoginPresenterImpl();
    }

    @Override
    public void onSuccess(LoginBean bean) {
        String message = bean.getMessage();
        Toast.makeText( this, "" + message, Toast.LENGTH_SHORT ).show();
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
