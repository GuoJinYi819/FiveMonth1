package com.bw.fivemonth1.mvp.login;

import com.bw.fivemonth1.bean.LoginBean;
import com.bw.fivemonth1.net.ApiService;
import com.bw.fivemonth1.net.RetrofitUtil;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * ClassName: FiveMonth1
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/14 15:20
 * @Description: 用途：完成特定功能
 */
public class LoginMouduleImpl implements ILoginContract.ILoginModlue {
    @Override
    public void loginUser(Map<String, String> param, ModuleCallBack moduleCallBack) {
        RetrofitUtil instance = RetrofitUtil.getInstance();
        ApiService service = instance.createService();
        Observable<LoginBean> observable = service.loginUser( param );
        observable.subscribeOn( Schedulers.io() )
                .observeOn( AndroidSchedulers.mainThread() )
                .subscribe( new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean value) {
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
