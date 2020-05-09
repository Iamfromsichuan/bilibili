package com.example.bilibili.activity;

import android.media.Image;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.example.bilibili.BaseActivity;
import com.example.bilibili.R;

public class LoginActivity extends BaseActivity {
    private ImageView ivClose;
    private ImageView ivSend;
    private EditText etPhone;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    public void init() {

    }

    @Override
    public void initView() {
        ivClose = findViewById(R.id.iv_close_login);
        ivSend = findViewById(R.id.iv_send_login);
        etPhone = findViewById(R.id.et_phone_login);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {

    }
}
