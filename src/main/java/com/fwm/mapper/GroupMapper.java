package com.fwm.mapper;

import com.fwm.pojo.Group;
import com.fwm.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @InterfaceName GroupMapper
 * @ProjectName chatRoom
 * @Description TODO
 * @Author 万民
 * @Date 2018/6/4 15:49
 * @Version 1.0
 **/
public interface GroupMapper {
    void insertGroup(Group group);
    void deleteGroup(@Param("group_name")String group_name);
    Group getGroupByName(@Param("group_name")String group_name);
    List<Group> getGroupsByUserName(@Param("user_name")String user_name);
    void insertUserGroup(@Param("user_name")String user_name, @Param("group_id")int group_id);
}
