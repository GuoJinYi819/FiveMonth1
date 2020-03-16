package com.bw.fivemonth2.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * ClassName: FiveMonth2
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/16 8:34
 * @Description: 用途：完成特定功能
 */
public abstract class BaseActivity<p extends BasePresenter> extends AppCompatActivity {
    protected p presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        int layoutId = initLayoutId();
        setContentView( layoutId );
        presenter = initPresenter();
        if (presenter != null) {
            presenter.attachView( this );
        }
        initView();
        initListener();
        initData();
    }
    protected abstract int initLayoutId();
    protected abstract void initView();
    protected abstract void initListener();
    protected abstract void initData();
    protected abstract p initPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
        }
    }
}
