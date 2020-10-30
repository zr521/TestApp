package com.example.test.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.test.R;
import com.example.test.util.BaseActivity;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {
    private ImageView Register_back;
    private Button Register_r;
    private EditText Register_user,Register_passed,Register_passwd_again,Register_email;
    private String users,passwds,passwd_agains,emails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initUI();
    }

    private void initUI() {
        Register_r = findViewById(R.id.register_r);
        Register_back = findViewById(R.id.register_back);
        Register_user = findViewById(R.id.register_user);
        Register_passed = findViewById(R.id.register_passwd);
        Register_passwd_again = findViewById(R.id.register_passwd_again);
        Register_email = findViewById(R.id.register_emali);

        Register_back.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register_back:
                navigateTo(LoginMainActivity.class);
                registerData(users,passwds,passwd_agains,emails);
               break;
        }
    }

    private void registerData(String user, String passwd, String passwd_again, String email) {
    user = Register_user.getText().toString();
    passwd = Register_passed.getText().toString();
    passwd_again = Register_passwd_again.getText().toString();
    email = Register_email.getText().toString();

    }


}