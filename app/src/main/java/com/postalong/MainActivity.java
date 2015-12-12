package com.postalong;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.postalong.modle.bean.DeliverInfo;
import com.postalong.modle.bean.OrderList;
import com.postalong.modle.service.ServiceClient;
import com.postalong.utils.Log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Map  paramsMap = new HashMap();
        paramsMap.put("page","1");
        paramsMap.put("pageSize","10");
        paramsMap.put("curJd","106.6007045");
        paramsMap.put("curWd","29.5342324");
        paramsMap.put("sortType", "dist");
        paramsMap.put("sortVal", "asc");
        paramsMap.put("reqTime", "2015-12-12 12:30:04");

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                Call<DeliverInfo> call= ServiceClient.getInstance().getAPIService().getGoodList(paramsMap);
//
//
//                call.enqueue(new Callback<DeliverInfo>() {
//                    @Override
//                    public void onResponse(Response<DeliverInfo> response, Retrofit retrofit) {
//                        Log.d(TAG,"response--"+response.message());
//                        List<OrderList> list = response.body().getRes().getOrderList();
//                        for(OrderList list1:list) {
//                            Log.d(TAG, list1.getInfo() + "-" + list1.getFinTime() + "-" + list1.getgName());
//                        }
//                        Log.d(TAG,"response--"+response.body().getRes().getSortType());
//                        Log.d(TAG,"response--"+list);
//                    }
//
//                    @Override
//                    public void onFailure(Throwable t) {
//                        Log.d(TAG,"OnError--"+t);
//                    }
//                });
//
//            }
//        }).start();

        ServiceClient.getInstance().getAPIService().getProductList(paramsMap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DeliverInfo>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError-" + e);
                    }

                    @Override
                    public void onNext(DeliverInfo deliverInfo) {
                        Log.d(TAG, "response--" + deliverInfo.getRet());
                        Log.d(TAG, deliverInfo.getRes().getSortType());
                        Log.d(TAG,deliverInfo.getRes().getOrderList().get(0).getgName());
                    }
                });


    }



    private void observable1() {
        Observable<String> myObservable = Observable.create(
                new Observable.OnSubscribe<String>() {

                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        subscriber.onNext("hello world");
                        subscriber.onNext("littleKang");
                        subscriber.onNext("流式");
                        subscriber.onCompleted();

                    }
                }
        );

        Subscriber<String> mySubscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Log.d(TAG,"onCompleted");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.d(TAG,"onNext--"+s);
            }
        };

        myObservable.subscribe(mySubscriber);
    }









    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
