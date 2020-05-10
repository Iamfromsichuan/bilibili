package com.example.bilibili.utls;

import com.example.bilibili.bmob.BBManager;
import com.example.bilibili.bmob.MyUser;
import com.example.bilibili.manager.UserManager;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

public class Login {
    private String phone;
    private LoginCallBack callBack;

    public void checkPhoneCode(String phone, String code, LoginCallBack callBack) {
        this.callBack = callBack;
        this.phone = phone;
        BBManager.getInstance().checkPhoneCode(phone, code, new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    findUserByPhone();
                } else {
                    callBack.error(e.getMessage(), e.getErrorCode());
                }
            }

        });
    }

    public interface LoginCallBack {
        void done(String id);

        void error(String errorMsg, int errorCode);
    }


    private void findUserByPhone() {
        BmobQuery<MyUser> query = new BmobQuery<>();
        query.addWhereEqualTo("phone", phone);
        query.findObjects(new FindListener<MyUser>() {
            @Override
            public void done(List<MyUser> list, BmobException e) {
                if (e == null) {
                    if (list.size() > 0) {
                        MyUser myUser = list.get(0);
                        UserManager.getInstance().saveUser(myUser);
                    } else {
                        createUser();
                    }
                } else {
                    callBack.error(e.getMessage(), e.getErrorCode());
                }
            }
        });
    }

    private void createUser() {
        MyUser user = new MyUser.Builder()
                .setName("鳄鱼戳背")
                .setPhone(phone)
                .setPayPWD("0000")
                .setPhotoUrl("null")
                .setMoney(0.0)
                .setUpMoney(0.0)
                .build();
        user.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if (e == null ) {
                    UserManager.getInstance().saveUser(user);
                    callBack.done(user.getObjectId());
                } else {
                    callBack.error(e.getMessage(), e.getErrorCode());
                }
            }
        });
    }

}
