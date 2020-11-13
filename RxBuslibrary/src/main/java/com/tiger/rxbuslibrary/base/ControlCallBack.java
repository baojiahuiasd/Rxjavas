package com.tiger.rxbuslibrary.base;

import com.tiger.rxbuslibrary.base.CallBack;

@FunctionalInterface
public interface ControlCallBack<T> {
    void contorllCallBack(CallBack< T> callBack);
}
