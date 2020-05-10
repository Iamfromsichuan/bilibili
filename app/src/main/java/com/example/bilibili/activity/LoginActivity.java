package com.example.bilibili.activity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.example.bilibili.BaseActivity;
import com.example.bilibili.R;
import com.example.bilibili.bmob.BBManager;
import com.xuexiang.xui.widget.toast.XToast;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private ImageView ivClose;
    private ImageView ivSend;
    private EditText etPhone;
    private String phone;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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
        ivClose.setOnClickListener(this);
        ivSend.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_close_login:
                finish();
                break;
            case R.id.iv_send_login:
                sendCode();
                break;
        }
    }

    private void sendCode() {
        phone = etPhone.getText().toString();
        if (phone.length() != 11) {
            XToast.warning(this, "请输入正确的手机号").show();
            return;
        }

        BBManager.getInstance().sendCode(phone, new QueryListener<Integer>() {
            @Override
            public void done(Integer integer, BmobException e) {
                if (e == null) {
                    Intent intent =
                            new Intent(LoginActivity.this,
                                    CheckActivity.class);
                    intent.putExtra("phone", phone);
                    startActivityForResult(intent, 1000);
                } else {
                    XToast.warning(LoginActivity.this, "失败   " + e.getErrorCode()).show();
                }
            }
        });

    }
}
