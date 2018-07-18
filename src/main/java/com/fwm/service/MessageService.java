package com.fwm.service;

import com.fwm.pojo.Message;

import java.util.List;

/**
 * @InterfaceName MessageService
 * @ProjectName chatRoom
 * @Description TODO
 * @Author 万民
 * @Date 2018/6/2 8:11
 * @Version 1.0
 **/
public interface MessageService {
    void addAsk(Message message);
    void addMessage(Message message);
    List<Message> listMessage(String user_name, String from, String to);
    List<Message> listAllMessage(String user_name, String to);
    List<Message> listAsk(String user_name);
    void deleteAsk(String from, String to);
}
