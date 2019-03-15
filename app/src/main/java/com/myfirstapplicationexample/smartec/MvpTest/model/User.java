package com.myfirstapplicationexample.smartec.MvpTest.model;

/**
 * Created by Abdelrahman Ibrahim on 3/15/2019.
 */
public class User {

    private String userName;
    private String userEmail;
    private Integer age;

    public User() {
    }

    public User(String firstName, String lastName, Integer age) {
        this.userName = firstName;
        this.userEmail = lastName;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
