package com.tiger.rxbuslibrary.base;

public interface CallBack<T> {
   void onNext(T t);
   void onCompile();
}
