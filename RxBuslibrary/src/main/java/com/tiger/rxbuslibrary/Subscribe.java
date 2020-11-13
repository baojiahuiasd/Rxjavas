package com.tiger.rxbuslibrary;

import com.tiger.rxbuslibrary.base.CallBack;
import com.tiger.rxbuslibrary.base.ControlCallBack;
import com.tiger.rxbuslibrary.base.SubscribeSource;
import com.tiger.rxbuslibrary.bus.AddSubscribeBean;
import com.tiger.rxbuslibrary.bus.CreateSubscribeBus;
import com.tiger.rxbuslibrary.io.CallBackIO;
import com.tiger.rxbuslibrary.io.SubscribeIO;

import java.util.function.Consumer;

public abstract class Subscribe<T> {

    public static <T> Subscribe<T> CreateSubScribe(ControlCallBack<T> callBack) {
        return new SubscribeSource<T>(callBack);
    }

    public Subscribe<T> SubscribeIO() {
        return new SubscribeIO<T>(this);
    }

    public Subscribe<T> CallBackIO() {
        return new CallBackIO<T>(this);
    }

    public static CreateSubscribeBus CreateSubscribeBus() {
        return new CreateSubscribeBus();
    }

    public <t> Subscribe<t> addSubscribeBean(Class<t> eventType) {
        AddSubscribeBean<t> tAddSubscribeBean = new AddSubscribeBean<t>((Subscribe<t>) this, eventType);
        return tAddSubscribeBean;
    }

    public void setListeners(Consumer<? super T> consumer) {
        setListener(new CallBack<T>() {
            @Override
            public void onNext(T t) {
                consumer.accept(t);
            }

            @Override
            public void onCompile() {
            }
        });
    }

    public abstract void setListener(CallBack<? super T> callBack);

}
