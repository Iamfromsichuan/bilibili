package com.example.bilibili.manager;

import com.example.bilibili.bmob.MyUser;

public class UserManager {
    private static UserManager userManager;
    private UserManager(){}

    public static UserManager getInstance() {
        if(userManager == null) {
            synchronized (UserManager.class) {
                if (userManager == null) {
                    userManager = new UserManager();
                }
            }
        }
        return userManager;
    }
    private MyUser myUser;
    public void saveUser(MyUser user) {
        myUser = user;
    }
    public MyUser getUser() {
        return myUser;
    }
    public void remove() {
        myUser = null;
    }
}
