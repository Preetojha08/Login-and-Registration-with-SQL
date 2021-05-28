package com.creatures.sqlloginandregistration;

public class model_user_registration_data {

    String user_name,user_mail,user_password;

    public model_user_registration_data(String user_name, String user_mail, String user_password) {
        this.user_name = user_name;
        this.user_mail = user_mail;

    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_mail() {
        return user_mail;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_mail(String user_mail) {
        this.user_mail = user_mail;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }


}
