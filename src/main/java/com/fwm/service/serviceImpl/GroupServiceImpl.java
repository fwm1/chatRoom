package com.fwm.service.serviceImpl;

import com.fwm.mapper.GroupMapper;
import com.fwm.pojo.Group;
import com.fwm.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName GroupServiceImpl
 * @ProjectName chatRoom
 * @Description TODO
 * @Author 万民
 * @Date 2018/6/4 22:11
 * @Version 1.0
 **/
@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    GroupMapper groupMapper;

    @Override
    public void insertGroup(Group group) {
        groupMapper.insertGroup(group);
    }

    @Override
    public void deleteGroup(String group_name) {
        groupMapper.deleteGroup(group_name);
    }

    @Override
    public Group getGroupByName(String group_name) {
        return groupMapper.getGroupByName(group_name);
    }

    @Override
    public List<Group> getGroupsByUserName(String user_name) {
        return groupMapper.getGroupsByUserName(user_name);
    }

    @Override
    public void insertUserGroup(String user_name, int group_id) {
        groupMapper.insertUserGroup(user_name, group_id);
    }
}
