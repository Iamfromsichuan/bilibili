package com.example.bilibili.bmob;

import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.listener.QueryListener;

public class BBManager {

    private static BBManager mBBManager;

    private BBManager() {
    }

    public static BBManager getInstance() {
        if (mBBManager == null) {
            synchronized (BBManager.class) {
                if (mBBManager == null) {
                    mBBManager = new BBManager();
                }
            }
        }
        return mBBManager;
    }

    public void sendCode(String phone, QueryListener<Integer> listener) {
        BmobSMS.requestSMSCode(phone, "", listener);
    }

}