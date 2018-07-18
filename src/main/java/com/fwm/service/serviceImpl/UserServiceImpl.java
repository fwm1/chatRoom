package com.fwm.service.serviceImpl;

import com.fwm.mapper.UserMapper;
import com.fwm.pojo.Group;
import com.fwm.pojo.User;
import com.fwm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @ProjectName chatRoom
 * @Description TODO
 * @Author 万民
 * @Date 2018/6/2 21:42
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> selectUserByName(String user_name) {
        return userMapper.selectUserByName(user_name);
    }

    @Override
    public User selectUser(User user) {
        return userMapper.selectUser(user);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void addFriend(String user_name, String friend_name) {
        userMapper.addFriend(user_name, friend_name);
    }

    @Override
    public void deleteFriend(String user_name, String friend_name) {
        userMapper.deleteFriend(user_name, friend_name);
    }

    @Override
    public List<User> listFriends(String user_name) {
        return userMapper.listFriends(user_name);
    }

    @Override
    public List<User> listMembersInGroup(String user_name) {
        return userMapper.listMembersInGroup(user_name);
    }

    @Override
    public List<String> listImpression(String user_name) {
        return userMapper.listImpression(user_name);
    }

    @Override
    public void addImpression(String user_name, String body) {
        userMapper.addImpression(user_name, body);
    }

}
