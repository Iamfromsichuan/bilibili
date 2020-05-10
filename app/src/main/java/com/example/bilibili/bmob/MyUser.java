package com.example.bilibili.bmob;

import cn.bmob.v3.BmobObject;

public class MyUser extends BmobObject {
    private String name;
    private String phone;
    private String photoUrl;
    private String payPWD;
    private Double money;
    private Double upMoney;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getPayPWD() {
        return payPWD;
    }

    public void setPayPWD(String payPWD) {
        this.payPWD = payPWD;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Double getUpMoney() {
        return upMoney;
    }

    public void setUpMoney(Double upMoney) {
        this.upMoney = upMoney;
    }



    public static class Builder{
        private String name;
        private String phone;
        private String photoUrl;
        private String payPWD;
        private Double money;
        private Double upMoney;

        public String getName() {
            return name;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public String getPhone() {
            return phone;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public String getPhotoUrl() {
            return photoUrl;
        }

        public Builder setPhotoUrl(String photoUrl) {
            this.photoUrl = photoUrl;
            return this;
        }

        public String getPayPWD() {
            return payPWD;
        }

        public Builder setPayPWD(String payPWD) {
            this.payPWD = payPWD;
            return this;
        }

        public Double getMoney() {
            return money;
        }

        public Builder setMoney(Double money) {
            this.money = money;
            return this;
        }

        public Double getUpMoney() {
            return upMoney;
        }

        public Builder setUpMoney(Double upMoney) {
            this.upMoney = upMoney;
            return this;
        }
        public MyUser build() {
            MyUser myUser = new MyUser();

            myUser.setMoney(money);
            myUser.setName(name);
            myUser.setPayPWD(payPWD);
            myUser.setPhone(phone);
            myUser.setPhotoUrl(photoUrl);
            myUser.setUpMoney(upMoney);

            return myUser;
        }
    }
}
