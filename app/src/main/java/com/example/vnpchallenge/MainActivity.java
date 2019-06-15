package com.example.vnpchallenge;

import android.content.Intent;
import android.content.SharedPreferences;

import com.example.vnpchallenge.base.BaseActivity;
import com.example.vnpchallenge.base.Constant;
import com.example.vnpchallenge.screen.HomeActivity;
import com.example.vnpchallenge.screen.LoginActivity;

public class MainActivity extends BaseActivity {
    public static String userID = "djtmetron";
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void setupUI() {
        //check if this device has been logged in
        SharedPreferences sharedPref = this.getSharedPreferences(Constant.USER, MainActivity.this.MODE_PRIVATE);
        String userID = sharedPref.getString(Constant.LOGIN, null);
        if (userID == null) {
            Intent intent = new Intent(this, LoginActivity.class);
            this.startActivity(intent);
            this.finish();
        } else {
            Intent intent = new Intent(this, HomeActivity.class);
            this.startActivity(intent);
            this.finish();
        }
    }
}
