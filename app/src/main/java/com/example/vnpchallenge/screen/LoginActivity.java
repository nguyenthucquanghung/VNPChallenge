package com.example.vnpchallenge.screen;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.vnpchallenge.R;
import com.example.vnpchallenge.base.BaseActivity;
import com.example.vnpchallenge.base.Constant;

public class LoginActivity extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void setupUI() {
        TextView tvRegister = findViewById(R.id.tv_register);
        tvRegister.setText(Html.fromHtml("<u>Create an account</u>"));

        Button btnLogin = findViewById(R.id.btn_login);
        final TextInputEditText edtUsername = findViewById(R.id.edt_username);
        final TextInputEditText edtPassword = findViewById(R.id.edt_password);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();
                if (validate(username, password)) {
                    SharedPreferences sharedPreferences = LoginActivity.this.getSharedPreferences(Constant.USER, LoginActivity.this.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(Constant.LOGIN, username);
                    editor.apply();

                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    LoginActivity.this.finish();
                    LoginActivity.this.startActivity(intent);
                }
            }
        });
    }

    private Boolean validate(String username, String password) {
        if (username.equals("admin") && password.equals("admin")) return true;
        else return false;
    }
}
