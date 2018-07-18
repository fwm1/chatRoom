package com.fwm.mapper;

import com.fwm.pojo.Group;
import com.fwm.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @InterfaceName UserMapper
 * @ProjectName chatRoom
 * @Description TODO
 * @Author 万民
 * @Date 2018/6/2 20:52
 * @Version 1.0
 **/
public interface UserMapper {
    List<User> selectUserByName(@Param("user_name")String user_name);
    User selectUser(User user);
    void addUser(User user);
    void addFriend(@Param("user_name")String user_name, @Param("friend_name")String friend_name);
    void deleteFriend(@Param("user_name")String user_name, @Param("friend_name")String friend_name);
    List<User> listFriends(@Param("user_name")String user_name);
    List<User> listMembersInGroup(@Param("user_name")String user_name);
    List<String> listImpression(@Param("user_name")String user_name);
    void addImpression(@Param("user_name")String user_name, @Param("body")String body);
}
