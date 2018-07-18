package com.fwm.mapper;

import com.fwm.pojo.Message;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Bean;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @InterfaceName MessageMapper
 * @ProjectName chatRoom
 * @Description TODO
 * @Author 万民
 * @Date 2018/6/2 8:04
 * @Version 1.0
 **/
public interface MessageMapper {
    void add(Message message);
    void addAsk(Message message);
    List<Message> list(@Param("user_name") String user_name, @Param("from")String from, @Param("to")String to);
    List<Message> listAll(@Param("user_name") String user_name,@Param("to")String to);
    List<Message> listAsk(@Param("user_name")String user_name);
    void deleteAsk(@Param("from")String from, @Param("to")String to);
}
