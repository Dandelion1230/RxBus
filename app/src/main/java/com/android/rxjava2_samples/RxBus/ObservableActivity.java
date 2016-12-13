package com.android.rxjava2_samples.RxBus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.android.rxjava2_samples.R;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class ObservableActivity extends AppCompatActivity {

    private TextView mText;
    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observable);
        mText = (TextView) findViewById(R.id.tv_text);
        disposable = RxBus.getDefault().toObservable(String.class)
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        mText.setText(s);
                    }
                });
    }

    public void onPost(View view) throws Throwable {
        if (view.getId() == R.id.post) {
            RxBus.getDefault().post("这是一个普通事件");
        } else {
            RxBus.getDefault().postSticky("这是一个Sticky事件");
            startActivity(new Intent(ObservableActivity.this, SubscribeActivity.class));
        }
    }

}
