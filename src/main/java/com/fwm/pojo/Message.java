package com.fwm.pojo;

import java.io.Serializable;

/**
 * @ClassName Message
 * @ProjectName chatRoom
 * @Description TODO
 * @Author 万民
 * @Date 2018/6/2 8:02
 * @Version 1.0
 **/
public class Message implements Serializable{
    private String  message_id;
    private String user_name;
    private String from;
    private String to;
    private String body;
    private String time;
    private int type;

    public Message(){}

    public Message(String user_name, String body, String from, String to){
        this.user_name = user_name;
        this.body = body;
        this.from = from;
        this.to = to;
    }
    public Message(String user_name,String from, String to, int type){
        this.user_name = user_name;
        this.from = from;
        this.to = to;
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMessage_id() {
        return message_id;
    }

    public void setMessage_id(String message_id) {
        this.message_id = message_id;
    }

    public String getuser_name() {
        return user_name;
    }

    public void setuser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
