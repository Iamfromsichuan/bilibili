package com.example.bilibili.app;

import android.app.Application;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.xuexiang.xui.XUI;

import cn.bmob.v3.Bmob;

public class App extends Application {
    private String key = "a331e7b155a93a6839a2b5b68892f825";
    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this, key);
        // 初始化
        XUI.init(this);
        XUI.debug(true);

        SDKInitializer.initialize(this);
        SDKInitializer.setCoordType(CoordType.BD09LL);
    }
}
