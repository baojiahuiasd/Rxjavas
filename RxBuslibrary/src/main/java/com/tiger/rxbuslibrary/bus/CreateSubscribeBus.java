package com.tiger.rxbuslibrary.bus;

import com.tiger.rxbuslibrary.Subscribe;
import com.tiger.rxbuslibrary.base.CallBack;
import com.tiger.rxbuslibrary.base.SubscribeBus;

import java.util.ArrayList;
import java.util.List;

public class CreateSubscribeBus extends Subscribe implements SubscribeBus {
    private volatile List<CallBack<?>> mCallBacks = new ArrayList<>();

    @Override
    public void setListener(CallBack callBack) {
        mCallBacks.add(callBack);

    }

    @Override
    public void post(Object o) {
        for (CallBack c : mCallBacks) {
            c.onNext(o);
        }

    }
}
