package com.bw.fivemonth1.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * ClassName: FiveMonth1
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/14 14:49
 * @Description: 用途：完成特定功能
 */
public abstract class BaseFragment<p extends BasePresenter> extends Fragment {
    protected p presenter;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layoutId = initLayoutId();
        view = View.inflate( getContext(), layoutId, null );
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated( savedInstanceState );
        presenter = initPresenter();
        if (presenter != null) {
            presenter.attachView( this );
        }
        initView( view );
        initListener();
        initData();
    }

    protected abstract int initLayoutId();
    protected abstract void initView(View view);
    protected abstract void initListener();
    protected abstract void initData();
    protected abstract p initPresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
        }
    }
}
