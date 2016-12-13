package com.android.rxjava2_samples.RxBus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.rxjava2_samples.R;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class SubscribeActivity extends AppCompatActivity {

    private TextView mText;
    private Disposable disposable, disposableSticky;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscrber);
        mText = (TextView) findViewById(R.id.tv_text);
        // 接收事件
        RxDisposable.getIntance().clear();
        disposable = RxBus.getDefault().toObservable(String.class)
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.e("TAG", s);
                        mText.setText(s);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e("TAG", throwable.getMessage());
                        mText.setText(throwable.getMessage());
                    }
                });
        RxDisposable.getIntance().add(disposable);

        RxDisposable.getIntance().clear();
        disposableSticky = RxBus.getDefault().toObservableSticky(String.class)
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String s) throws Exception {
                        try {
                            // 变换操作
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return s;
                    }
                })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.e("TAG", s+"-----");
                        Toast.makeText(SubscribeActivity.this, s, Toast.LENGTH_SHORT).show();
                        mText.setText(s);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e("TAG", throwable.getMessage());
                        Toast.makeText(SubscribeActivity.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        RxDisposable.getIntance().add(disposableSticky);
    }

    public void onPost(View view) {
        RxBus.getDefault().postSticky("这是一个普通事件");
        RxBus.getDefault().postSticky("这是异常后的事件");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxDisposable.getIntance().clear();
    }
}
