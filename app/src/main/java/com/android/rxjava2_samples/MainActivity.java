package com.android.rxjava2_samples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.android.rxjava2_samples.RxBus.ObservableActivity;
import com.android.rxjava2_samples.snackbar.SnackBarActivity;
import com.orhanobut.logger.Logger;

public class MainActivity extends AppCompatActivity {

    private String[] texts = {"RxBus", "SnackBar"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View view) {
        if (view.getId() == R.id.btn_rxbus) {
            startActivity(ObservableActivity.class);
        } else if (view.getId() == R.id.btn_snack) {
            startActivity(SnackBarActivity.class);
        }else if (view.getId() == R.id.btn_log) {
            Logger.d("Test");
        }
    }


    private void startActivity(Class clazz) {
        startActivity(new Intent(this, clazz));
    }
}
