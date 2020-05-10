package com.example.bilibili.bmob;

import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.UpdateListener;

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

    /**
     * 验证验证吗
     * @param phone 手机号
     * @param code 验证吗
     * @param listener 结果回调
     */
    public void checkPhoneCode(String phone, String code, UpdateListener listener) {
        BmobSMS.verifySmsCode(phone, code, listener);
    }

}