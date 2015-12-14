package com.postalong.rxbus;


import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created by heshaokang on 2015/12/14.
 * RxBus 用RxJava 实现的EventBus
 *
 */
public class RxBus {

    private final Subject<Object,Object> bus = new SerializedSubject<>(PublishSubject.create());
    private RxBus rxBus = null;
    private RxBus(){

    }

    public void getInstance() {

        if(rxBus==null) {
            synchronized (RxBus.class) {
                if(rxBus==null) {
                    rxBus = new RxBus();
                }
            }
        }
    }

    public void send(Object o) {
        bus.onNext(o);
    }

    public Observable<Object> toObservable() {
        return bus;
    }

    public boolean hasObservable() {
        return bus.hasObservers();
    }
}
