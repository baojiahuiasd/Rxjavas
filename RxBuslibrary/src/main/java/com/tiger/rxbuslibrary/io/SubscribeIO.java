package com.tiger.rxbuslibrary.io;

import com.tiger.rxbuslibrary.base.CallBack;
import com.tiger.rxbuslibrary.Subscribe;

public class SubscribeIO<T> extends Subscribe<T> {
    private Subscribe upSubscribe;

    public <T>SubscribeIO(Subscribe<T> subscribe) {
        this.upSubscribe = subscribe;
    }

    @Override
    public void setListener(final CallBack<? super T> callBack) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                upSubscribe.setListener(callBack);
            }
        },"线程1").start();
    }


}
