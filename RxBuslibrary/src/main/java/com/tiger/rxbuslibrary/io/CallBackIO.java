package com.tiger.rxbuslibrary.io;

import com.tiger.rxbuslibrary.base.CallBack;
import com.tiger.rxbuslibrary.Subscribe;

public class CallBackIO<T> extends Subscribe<T> {
    private Subscribe upSubscribe;


    public<T> CallBackIO(Subscribe<T> subscribe) {
        upSubscribe = subscribe;
    }

    @Override
    public void setListener(CallBack<? super T> callBack) {
        upSubscribe.setListener(new CallBackMainIO<T>(callBack));
    }

    public class CallBackMainIO<T> implements CallBack<T> {
        private CallBack<? super T> proxCallBack;

        public CallBackMainIO(CallBack<? super T> callBack) {
            proxCallBack=callBack;
        }

        @Override
        public void onNext(final T o) {
            System.out.println("这里执行");
             new Thread(new Runnable() {
                @Override
                public void run() {
                    proxCallBack.onNext(o);
                }
            }, "线程2").start();
        }

        @Override
        public void onCompile() {

        }
    }
}
