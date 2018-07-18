package com.fwm.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName User
 * @ProjectName chatRoom
 * @Description TODO
 * @Author 万民
 * @Date 2018/6/2 20:47
 * @Version 1.0
 **/
public class User implements Serializable{
    private String user_name;
    private String password;
    private int role;
    private String group_id = null;
    private String sex;
    private int age;
    private String email;
    private String address;
    private List<User> friends;
    private List<String> impressions;
    private long qq_id;

    public User(){}
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public User(String user_name, String password, String sex, int age, String email, String address) {
        this.user_name = user_name;
        this.password = password;
        this.address = address;
        this.email = email;
        this.age = age;
        this.sex = sex;
    }

    public long getQq_id() {
        return qq_id;
    }

    public void setQq_id(long qq_id) {
        this.qq_id = qq_id;
    }

    public List<String> getImpressions() {
        return impressions;
    }

    public void setImpressions(List<String> impressions) {
        this.impressions = impressions;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
