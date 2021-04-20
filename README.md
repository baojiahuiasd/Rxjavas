# Rxjavas
项目位置 RxBusLibrary  
使用案例  



   //Rxjava的一些使用
   Subscribe.CreateSubScribe(new ControlCallBack<String>() {
            @Override
            public void contorllCallBack(CallBack<String> callBack) {
                System.out.println("----------------------------contorllCallBack-------------------------------------");
                callBack.onNext("onNextonNextonNextonNextonNextonNext");
                System.out.println("发送消息：onNextonNextonNextonNextonNextonNext");
                System.out.println("当前线程" + Thread.currentThread().getName());
            }
            //设置被观察者和观察者的执行线程
        }).CallBackIO().SubscribeIO().setListener(new CallBack<String>() {
            @Override
            public void onNext(String s) {
                System.out.println("----------------------------onNext-------------------------------------");
                System.out.println("接受消息：" + s);
                System.out.println("当前线程" + Thread.currentThread().getName());
            }
            @Override
            public void onCompile() {

            }
        });
    Subscribe.CreateSubScribe(new ControlCallBack<String>() {
            @Override
            public void contorllCallBack(CallBack<String> callBack) {
                System.out.println("----------------------------contorllCallBack-------------------------------------");
                callBack.onNext("abcdefghijklmnopqrstuvwxyz");
                System.out.println("发送消息：abcdefghijklmnopqrstuvwxyz");
                System.out.println("当前线程" + Thread.currentThread().getName());
            }
            //颠倒位置测试
        }).SubscribeIO().CallBackIO().setListener(new CallBack() {
            @Override
            public void onNext(Object o) {
                System.out.println("----------------------------onNext-------------------------------------");
                System.out.println("接受消息：" + o.toString());
                System.out.println("当前线程" + Thread.currentThread().getName());
            }

            @Override
            public void onCompile() {

            }
        });
        //Rxbus的测试案例
        CreateSubscribeBus createSubscribeBus = Subscribe.CreateSubscribeBus();
        //同样可以设置线程
        createSubscribeBus.addSubscribeBean(Student.class).SubscribeIO().CallBackIO().setListeners(new Consumer<Student>() {
            @Override
            public void accept(Student o) {
                System.out.println("当前线程:接受数据" + Thread.currentThread().getName());
            }
        });
        Thread.sleep(1000);
        createSubscribeBus.post(new Student());
