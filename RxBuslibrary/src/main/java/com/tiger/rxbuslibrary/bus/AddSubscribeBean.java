package com.tiger.rxbuslibrary.bus;

import com.tiger.rxbuslibrary.Subscribe;
import com.tiger.rxbuslibrary.base.CallBack;

public class AddSubscribeBean<T> extends Subscribe<T> {
    public Subscribe<T> upSubscribe;
    public Class<T> aClass;

    public  AddSubscribeBean(Subscribe<T> subscribe, Class<T>  c) {
        upSubscribe = subscribe;
        aClass = c;
    }

    @Override
    public void setListener(CallBack<? super T> callBack) {
        upSubscribe.setListener(new ClassInstanceCallBak<T>(callBack));
    }

    public class ClassInstanceCallBak<T> implements CallBack<T> {
        public CallBack<? super T>  mCallBack;

        public ClassInstanceCallBak(CallBack<? super T> callBack) {
            mCallBack = callBack;
        }

        @Override
        public void onNext(T o) {
            if (aClass.isInstance(o)) {
                mCallBack.onNext(o);
            }
        }

        @Override
        public void onCompile() {

        }
    }
}
