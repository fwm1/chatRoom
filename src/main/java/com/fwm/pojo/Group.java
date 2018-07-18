package com.fwm.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName Group
 * @ProjectName chatRoom
 * @Description TODO
 * @Author 万民
 * @Date 2018/6/4 15:24
 * @Version 1.0
 **/
public class Group implements Serializable{
    private int group_id;
    private String group_name;

    public Group(String group_name) {
        this.group_name = group_name;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }
}
