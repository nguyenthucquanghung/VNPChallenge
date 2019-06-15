package com.example.vnpchallenge.screen;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.vnpchallenge.R;
import com.example.vnpchallenge.base.BaseActivity;

public class HomeActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void setupUI() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bot_nav_view_home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_new:
                        break;
                    case R.id.action_order:
                        break;
                    case R.id.action_user:
                        break;
                }
                return true;
            }
        });
    }
}
