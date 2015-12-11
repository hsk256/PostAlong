package com.postalong;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.postalong.modle.bean.Course;
import com.postalong.modle.bean.Student;
import com.postalong.utils.Log;

import java.util.Observer;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getCourse();
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

    private void observable2() {
        Observable<String> myObservable1 = Observable.just("littleKang");
        Action1<String> onNextAction = new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d(TAG,"onNextAction--"+s);
            }
        };

        Action1<Throwable> onError = new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Log.d(TAG,"onError");
            }
        };


        Action0 onComplete = new Action0() {
            @Override
            public void call() {
                Log.d(TAG,"onComplete");
            }
        };
        myObservable1.subscribe(onNextAction,onError,onComplete);
    }


    private void observable3() {
        Observable.just("hello world")
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        return s+"--littleKang";
                    }
                })
                .subscribe(
                        new Action1<String>() {
                            @Override
                            public void call(String s) {
                                Log.d(TAG, s);
                            }
                        }
                );
    }


    private void getCourse() {

        Course course1 = new Course("语文");
        Course course2 = new Course("数学");
        Course course3 = new Course("英语");
        Course[] courses1 = new Course[]{course1,course2};
        Course[] courses2 = new Course[]{course1,course3};
        Course[] courses3 = new Course[]{course1,course2,course3};

        Student student1 = new Student("student1",courses1);
        Student student2 = new Student("student2",courses2);
        Student student3 = new Student("student3",courses3);

        Student[] students = new Student[]{student1,student2,student3};

        Subscriber<Course> subscriber = new Subscriber<Course>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Course course) {
                Log.d(TAG,course.getName());
            }
        };

        Observable.from(students)
                .flatMap(new Func1<Student, Observable<Course>>() {
                    @Override
                    public Observable<Course> call(Student student) {


                        return Observable.from(student.getCourse());


                    }
                })
                .subscribe(subscriber);
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
