package com.fwm.service.serviceImpl;

import com.fwm.mapper.MessageMapper;
import com.fwm.pojo.Message;
import com.fwm.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName MessageServiceImpl
 * @ProjectName chatRoom
 * @Description TODO
 * @Author 万民
 * @Date 2018/6/2 8:12
 * @Version 1.0
 **/
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageMapper messageMapper;

    @Override
    public void addAsk(Message message) {
        messageMapper.addAsk(message);
    }

    @Override
    public void addMessage(Message message) {
        messageMapper.add(message);
    }

    @Override
    public List<Message> listMessage(String user_name, String from, String to) {
        return messageMapper.list(user_name, from, to);
    }

    @Override
    public List<Message> listAllMessage(String user_name, String to) {
        return messageMapper.listAll(user_name, to);
    }

    @Override
    public List<Message> listAsk(String user_name) {
        return messageMapper.listAsk(user_name);
    }

    @Override
    public void deleteAsk(String from,String to) {
        messageMapper.deleteAsk(from,to);
    }
}
