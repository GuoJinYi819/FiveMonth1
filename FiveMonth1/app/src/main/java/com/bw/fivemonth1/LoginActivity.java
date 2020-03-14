package com.bw.fivemonth1;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bw.fivemonth1.base.BaseActivity;
import com.bw.fivemonth1.base.BasePresenter;

import java.util.HashMap;

import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.editPhone)
    EditText editPhone;
    @BindView(R.id.editPwd)
    EditText editPwd;
    @BindView(R.id.btnLogin)
    Button btnLogin;
    @BindView(R.id.btnRegister)
    Button btnRegister;
    private Unbinder unbind;

    @Override
    protected int initLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        unbind = ButterKnife.bind( this );
    }
    //点击事件
    @OnClick({R.id.btnLogin, R.id.btnRegister})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                String phone = editPhone.getText().toString().trim();
                String pwd = editPwd.getText().toString().trim();
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put( "phone",phone );
                hashMap.put( "pwd",pwd );

                break;
            case R.id.btnRegister:
                Intent intent = new Intent( LoginActivity.this, RegisterActivity.class );
                startActivityForResult( intent, 100 );
                break;
        }
    }
    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult( requestCode, resultCode, data );
        if (requestCode==100&&resultCode==100&&data!=null) {
            String phone = data.getStringExtra( "phone" );
            String pwd = data.getStringExtra( "pwd" );
            editPwd.setText( pwd );
            editPhone.setText( phone );
        }
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbind != null) {
            unbind.unbind();
        }
    }
}