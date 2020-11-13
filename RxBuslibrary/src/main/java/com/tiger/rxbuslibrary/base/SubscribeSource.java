package com.tiger.rxbuslibrary.base;

import com.tiger.rxbuslibrary.Subscribe;

public class SubscribeSource<T> extends Subscribe<T> {
    public ControlCallBack mControlCallBack;
    public SubscribeSource(ControlCallBack<T> callBack){
        mControlCallBack = callBack;
    }

    @Override
    public void setListener(CallBack<? super T > callBack) {
        mControlCallBack.contorllCallBack(callBack);
    }
}
