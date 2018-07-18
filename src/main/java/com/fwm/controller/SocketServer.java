package com.fwm.controller;


        import com.alibaba.fastjson.JSON;
        import com.alibaba.fastjson.JSONObject;
        import com.fwm.pojo.Message;
        import com.fwm.service.MessageService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.socket.server.standard.SpringConfigurator;

        import javax.websocket.*;
        import javax.websocket.server.PathParam;
        import javax.websocket.server.ServerEndpoint;
        import java.text.SimpleDateFormat;
        import java.util.Date;
        import java.util.concurrent.ConcurrentHashMap;
        import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName SocketServer
 * @ProjectName WebSocket
 * @Description TODO
 * @Author 万民
 * @Date 2018/5/23 21:09
 * @Version 1.0
 * /**
 *  @ServerEndpoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端,
 * 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
 **/
//JSON    {"from":"fwm","to":["zcy","zj","hsy"]}
@Controller
@ServerEndpoint(value = "/ws/{userId}", configurator = SpringConfigurator.class)
/*configurator = SpringConfigurator.class 取代了默认的Configurator, 使得我们可以正确使用Spring进行实例化注入，否则
 * 注入的service会得到NUllPointException，因为它是由webSocket实现实例化，并不会自动注入
 * */
public class SocketServer {
    @Autowired
    MessageService messageService;
    //用户Id - SocketServer
    private static ConcurrentHashMap<String, SocketServer> users = new ConcurrentHashMap<>();
    //在线人数,用原子类实现并发
    private static AtomicInteger onlineNum = new AtomicInteger(0);
    //与某个客户端的连接会话， 需要它来给客户端发送数据
    Session session;
    //用户id
    String userId;

    @OnOpen
    public void onOpen(@PathParam("userId")String userId, Session session){
        this.userId = userId;
        this.session = session;
        users.put(userId, this);
        onlineNum.incrementAndGet();
    }
    @OnMessage
    public void onMessage (@PathParam("userId")String userId, String message){
        JSONObject jsonObject = JSONObject.parseObject(message);
        String to = jsonObject.getString("to");
        String body = jsonObject.getString("body");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time = format.format(new Date());
        //发回的数据中有时间、消息发送者
        jsonObject.put("time", time);
        jsonObject.put("from",userId);
        //返回的消息Json格式字符串
        String returnMessage = JSON.toJSONString(jsonObject);
        if(to == null){
            broadcast(userId, returnMessage);
        }else {
            //广播给client
            sendToUser(to, returnMessage);
            //数据入库
            messageService.addMessage(new Message(userId, body, userId, to));
        }
    }
    @OnError
    public void onError(Session session, Throwable throwable){
        throwable.printStackTrace();
        users.remove(userId);
        onlineNum.decrementAndGet();
    }
    @OnClose
    public void onClose(CloseReason closeReason){
        broadcast(userId, userId+"已离线");
        users.remove(userId);
        onlineNum.decrementAndGet();
    }

    public static void sendToUser(String client, String message){
        if(users.containsKey(client)){
            users.get(client).sendMessage(message);
        }
    }
    public static void broadcast(String userId,String message){
        for(String user: users.keySet()){
            if(!user.equals(userId)){
                users.get(user).sendMessage(message);
            }
        }
    }
    public void sendMessage(String message){
        this.session.getAsyncRemote().sendText(message);
    }
}
