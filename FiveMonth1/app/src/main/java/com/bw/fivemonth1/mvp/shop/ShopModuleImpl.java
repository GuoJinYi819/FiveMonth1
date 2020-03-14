package com.bw.fivemonth1.mvp.shop;

import com.bw.fivemonth1.bean.ShopBean;
import com.bw.fivemonth1.net.ApiService;
import com.bw.fivemonth1.net.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * ClassName: FiveMonth1
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/14 15:50
 * @Description: 用途：完成特定功能
 */
public class ShopModuleImpl implements IShopContract.IShopModlue {
    @Override
    public void getShop(ModuleCallBack moduleCallBack) {
        RetrofitUtil instance = RetrofitUtil.getInstance();
        ApiService service = instance.createService();
        Observable<ShopBean> observable = service.getShop();
        observable.subscribeOn( Schedulers.io() )
                .observeOn( AndroidSchedulers.mainThread() )
                .subscribe( new Observer<ShopBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ShopBean value) {
                        moduleCallBack.onSuccess( value );
                    }

                    @Override
                    public void onError(Throwable e) {
                        moduleCallBack.onFailed( e.getMessage() );
                    }

                    @Override
                    public void onComplete() {

                    }
                } );

    }
}
