package com.android.rxjava2_samples.snackbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.rxjava2_samples.R;

public class SnackBarActivity extends AppCompatActivity {

    private Button snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar);
        snackbar = (Button) findViewById(R.id.snack1);
    }

    public void onClick(View view) {
        InputUtils.HideKeyboard(findViewById(R.id.edit));
        if (view.getId() == R.id.snack1) {
            SnackBarUtils.shortShow(snackbar, "默认的SnackBar");
        } else if (view.getId() == R.id.snack2) {
            SnackBarUtils.colorShow(snackbar, "颜色的SnackBar", Color.WHITE, Color.parseColor("#FF5555"));
        } else if (view.getId() == R.id.snack3) {
            SnackBarUtils.imageShow(SnackBarActivity.this, snackbar, "图片的SnackBar", R.mipmap.ic_launcher);
        } else if (view.getId() == R.id.snack4) {
            View.OnClickListener onClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(SnackBarActivity.this, "被点击了", Toast.LENGTH_SHORT).show();
                }
            };
            SnackBarUtils.actionShow(snackbar, "Action的SnackBar", "点击", Color.BLUE, onClickListener);
        }
    }
}
