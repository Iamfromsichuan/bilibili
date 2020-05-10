package com.example.bilibili.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import com.example.bilibili.BaseActivity;
import com.example.bilibili.R;
import com.example.bilibili.bmob.BBManager;
import com.google.android.material.button.MaterialButton;
import com.xuexiang.xui.widget.edittext.verify.VerifyCodeEditText;
import com.xuexiang.xui.widget.toast.XToast;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;

public class CheckActivity extends BaseActivity implements View.OnClickListener {

    private ImageView ivClose;
    private TextView tvPhone;
    private ImageView ivUp;
    private VerifyCodeEditText etCode;
    private MaterialButton btnSend;

    private int count = 60;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                btnSend.setEnabled(true);
                btnSend.setText("重新发送");
                btnSend.setBackgroundColor(
                        ActivityCompat.getColor(CheckActivity.this,
                                R.color.main_color)
                );
            } else {
                if (btnSend != null) {
                    count--;
                    btnSend.setText(count + "s");
                }
                handler.sendEmptyMessageDelayed(count, 1000);
            }
        }
    };

    private String phone;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        initView();
    }

    @Override
    public void init() {
        Intent intent = getIntent();
        phone = intent.getStringExtra("phone");
        tvPhone.setText(phone);
    }

    @Override
    public void initView() {
        ivClose = findViewById(R.id.iv_close_check);
        tvPhone = findViewById(R.id.tv_phone_check);
        ivUp = findViewById(R.id.iv_up_check);
        etCode = findViewById(R.id.et_code_check);
        btnSend = findViewById(R.id.btn_time);

        ivClose.setOnClickListener(this);
        ivUp.setOnClickListener(this);
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
            case R.id.iv_close_check:
            case R.id.iv_up_check:
                finish();
                break;
            case R.id.btn_time:
                sendCode();
                break;
        }
    }

    public void sendCode() {
        BBManager.getInstance().sendCode(phone, new QueryListener<Integer>() {
            @Override
            public void done(Integer integer, BmobException e) {
                if (e == null) {
                    XToast.success(CheckActivity.this, "发送成功").show();
                } else {
                    XToast.error(CheckActivity.this,
                            "发送失败").show();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.sendEmptyMessage(count);
    }
}
