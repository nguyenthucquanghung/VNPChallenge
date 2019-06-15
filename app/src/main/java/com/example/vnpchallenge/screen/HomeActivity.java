package com.example.vnpchallenge.screen;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserPool;
import com.example.vnpchallenge.R;
import com.example.vnpchallenge.base.BaseActivity;

public class HomeActivity extends BaseActivity {
    final Fragment createOrderFragment = new CreateOrderFragment();
    final Fragment userFragment = new UserFragment();
    final Fragment orderListFragment = new OrderListFragment();
    final FragmentManager fragmentManager = getSupportFragmentManager();
    Fragment activeFragment = createOrderFragment;
    final String userPoolId ="Customers";
    final String clientId = "66g1s5h6d05d8hbau9nfhrno8d";
    final String clientSecret = "h8rfes10vbhbide30jdq6ue1dj6utlfl9s5i96ah0adhrjclj4b";

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }


    private void setUpBottomNavigation(){
        BottomNavigationView bottomNavigationView = findViewById(R.id.bot_nav_view_home);
        CognitoUserPool userPool = new CognitoUserPool(getApplicationContext(), userPoolId, clientId, clientSecret);

        fragmentManager
                .beginTransaction()
                .add(R.id.home_container, orderListFragment, "2")
                .hide(orderListFragment)
                .commit();
        fragmentManager
                .beginTransaction()
                .add(R.id.home_container, userFragment, "3")
                .hide(userFragment).commit();
        fragmentManager
                .beginTransaction()
                .add(R.id.home_container, createOrderFragment, "1")
                .commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView
                .OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_new:
                        fragmentManager
                                .beginTransaction()
                                .hide(activeFragment)
                                .show(createOrderFragment)
                                .commit();
                        activeFragment = createOrderFragment;
                        break;
                    case R.id.action_order:
                        fragmentManager
                                .beginTransaction()
                                .hide(activeFragment)
                                .show(orderListFragment).commit();
                        activeFragment = orderListFragment;
                        break;
                    case R.id.action_user:
                        fragmentManager
                                .beginTransaction()
                                .hide(activeFragment)
                                .show(userFragment).commit();
                        activeFragment = userFragment;
                        break;
                }
                return true;
            }
        });
    }
    @Override
    protected void setupUI() {
        setUpBottomNavigation();
    }
}
