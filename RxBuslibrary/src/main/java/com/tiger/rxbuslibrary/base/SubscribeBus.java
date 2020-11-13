package com.tiger.rxbuslibrary.base;

public interface SubscribeBus<T> {
    void post(T t);
}
