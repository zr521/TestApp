package com.example.test.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.test.R;
import com.example.test.util.BaseActivity;

public class AdvertisingActivity extends BaseActivity {

    private Handler handler = new Handler(){
        public void handleMessage(Message message){
            //如果当前activity已经退出，那就不处理handler中的消息
            if(isFinishing()){
                return;
            }
            //判断进入主页面还是登录页面
            toMianOrLogin();
        }

    };
    //判断进入主页面还是登录页面
    private void toMianOrLogin() {
        new Thread(){
            @Override
            public void run() {
                super.run();
                //判断当前账号是否登录过
                navigateTo(LoginMainActivity.class);
            }
        }.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertising);

        //发送2s钟的延迟
        handler.sendMessageDelayed(Message.obtain(),2000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //销毁消息
        handler.removeCallbacksAndMessages(null);
    }
}