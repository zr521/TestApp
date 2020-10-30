package com.example.test.Activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.MainActivity;
import com.example.test.R;
import com.example.test.util.BaseActivity;
import com.example.test.util.StringUtils;

import java.util.HashMap;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private ImageView Login_back;
    private EditText Login_User,Login_Passwd;
    private Button Login_login,Login_Cancle;
    private String users,passwds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initUI();//UI界面

    }

    private void initUI() {
        Login_User = findViewById(R.id.login_user);//用户
        Login_Passwd = findViewById(R.id.login_passwd);//mima
        Login_login = findViewById(R.id.login_login);
        Login_Cancle = findViewById(R.id.login_cancle);
        Login_back = findViewById(R.id.login_back);

        Login_back.setOnClickListener(this);
        Login_Cancle.setOnClickListener(this);
        Login_login.setOnClickListener(this);
        Login_Passwd.setOnClickListener(this);
        Login_User.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_login: loginData(users,passwds);
                break;
            case R.id.login_cancle:
                navigateTo(RegisterActivity.class);
                break;
            case R.id.login_back:
                navigateTo(LoginMainActivity.class);
                break;

        }

    }

    private void loginData(String user, String passwd) {
        user = Login_User.getText().toString().trim();//获取用户名
        passwd = Login_Passwd.getText().toString().trim();//获取密码

        if(StringUtils.isEmpty(user) || StringUtils.isEmpty(passwd)){
            showToast("账号不能为空");
            showToast("密码不能为空");
            return;
        }else {
            if(StringUtils.isGreater_user(user) || StringUtils.isGreater_passwd(passwd)){
                showToast("账号不符合");
                showToast("密码错误");
            }
        }

//        if(StringUtils.isEmpty(user)  ){
//            showToast("账号不能为空");
//            return;
//        }else{
//            if(StringUtils.isGreater_user(user)){
//                showToast("账号不符合");
//                return;
//            }
//        }
//        if(StringUtils.isEmpty(passwd)){
//            showToast("密码不能为空");
//            return;
//        }else {
//            if(StringUtils.isGreater_passwd(passwd)){
//                showToast("密码错误");
//                return;
//            }
//        }


        /**
         * 登陆等待动画
         */
        final ProgressDialog pd = new ProgressDialog(LoginActivity.this);//等待动画
        pd.setMessage("正在登录...");//提示信息
        pd.show();//显示等待条

        /**
         * 模拟后台
         */
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                pd.dismiss();//消失等待条

                navigateTo(MainActivity.class);//登陆成功跳转
                finish();//结束当前页面
            }
        }).start();//开启线程


    }
}