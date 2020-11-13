package com.tiger.rxbuslibrary;

import com.tiger.rxbuslibrary.bus.CreateSubscribeBus;

import java.util.function.Consumer;


public class main {
    public static void main(String[] args) throws InterruptedException {
//        Subscribe.CreateSubScribe(new ControlCallBack<String>() {
//            @Override
//            public void contorllCallBack(CallBack<String> callBack) {
//                System.out.println("----------------------------contorllCallBack-------------------------------------");
//                callBack.onNext("abcdefghijklmnopqrstuvwxyz");
//                System.out.println("发送消息：abcdefghijklmnopqrstuvwxyz");
//                System.out.println("当前线程" + Thread.currentThread().getName());
//            }
//        }).CallBackIO().SubscribeIO().setListener(new CallBack<String>() {
//            @Override
//            public void onNext(String s) {
//                System.out.println("----------------------------onNext-------------------------------------");
//                System.out.println("接受消息：" + s.toString());
//                System.out.println("当前线程" + Thread.currentThread().getName());
//            }
//
//            @Override
//            public void onCompile() {
//
//            }
//        });
//        Subscribe.CreateSubScribe(new ControlCallBack<String>() {
//            @Override
//            public void contorllCallBack(CallBack<String> callBack) {
//                System.out.println("----------------------------contorllCallBack-------------------------------------");
//                callBack.onNext("abcdefghijklmnopqrstuvwxyz");
//                System.out.println("发送消息：abcdefghijklmnopqrstuvwxyz");
//                System.out.println("当前线程" + Thread.currentThread().getName());
//            }
//        }).SubscribeIO().CallBackIO().setListener(new CallBack() {
//            @Override
//            public void onNext(Object o) {
//                System.out.println("----------------------------onNext-------------------------------------");
//                System.out.println("接受消息：" + o.toString());
//                System.out.println("当前线程" + Thread.currentThread().getName());
//            }
//
//            @Override
//            public void onCompile() {
//
//            }
//        });
        CreateSubscribeBus createSubscribeBus = Subscribe.CreateSubscribeBus();
        createSubscribeBus.addSubscribeBean(Student.class).SubscribeIO().CallBackIO().setListeners(new Consumer<Student>() {
            @Override
            public void accept(Student o) {
                System.out.println("当前线程:接受数据" + Thread.currentThread().getName());
            }
        });
        Thread.sleep(1000);
        createSubscribeBus.post(new Student());

    }
}

