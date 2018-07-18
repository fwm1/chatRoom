package com.fwm.service;

import com.fwm.pojo.Group;
import com.fwm.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @InterfaceName UserService
 * @ProjectName chatRoom
 * @Description TODO
 * @Author 万民
 * @Date 2018/6/2 21:39
 * @Version 1.0
 **/
public interface UserService {
    List<User> selectUserByName(String user_name);
    User selectUser(User user);
    void addUser(User user);
    void addFriend(String user_name, String friend_name);
    void deleteFriend(String user_name, String friend_name);
    List<User> listFriends(String user_name);
    List<User> listMembersInGroup(String user_name);
    List<String> listImpression(String user_name);
    void addImpression(String user_name, String body);
}
