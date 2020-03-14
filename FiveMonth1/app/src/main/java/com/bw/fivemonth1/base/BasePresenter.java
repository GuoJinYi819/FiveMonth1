package com.bw.fivemonth1.base;

/**
 * ClassName: FiveMonth1
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/14 14:47
 * @Description: 用途：完成特定功能
 */
public abstract class BasePresenter<view> {

    protected view baseView;

    public BasePresenter() {
        initMoudle();
    }

    //绑定
    protected void attachView(view v){
        this.baseView = v;
    }
    //解绑
    protected void detachView(){
        if (baseView != null) {
            baseView = null;
        }
    }
    protected abstract void initMoudle();
}
