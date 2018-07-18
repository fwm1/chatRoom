package com.fwm.service;

import com.fwm.pojo.Group;

import java.util.List;

/**
 * @InterfaceName GroupService
 * @ProjectName chatRoom
 * @Description TODO
 * @Author 万民
 * @Date 2018/6/4 22:10
 * @Version 1.0
 **/
public interface GroupService {
    void insertGroup(Group group);
    void deleteGroup(String group_name);
    Group getGroupByName(String group_name);
    List<Group> getGroupsByUserName(String user_name);
    void insertUserGroup(String user_name, int group_id);
}
