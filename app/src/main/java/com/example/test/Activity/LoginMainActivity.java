package com.example.test.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.test.R;
import com.example.test.util.BaseActivity;

public class LoginMainActivity extends BaseActivity implements View.OnClickListener {
    private TextView Login_mian_else;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);
        initUI();
    }

    private void initUI() {
        Login_mian_else = findViewById(R.id.login_main_else);
        Login_mian_else.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_main_else:
                navigateTo(LoginActivity.class);
        }
    }
}