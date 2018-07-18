package com.fwm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fwm.pojo.Message;
import com.fwm.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

/**
 * @ClassName MessageController
 * @ProjectName chatRoom
 * @Description TODO
 * @Author 万民
 * @Date 2018/6/7 20:40
 * @Version 1.0
 **/
@Controller
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @RequestMapping(value = "/listHistory/{from}", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String showMessages(@PathVariable("from")String from, HttpServletRequest request){
        System.out.println("showMessages");
        System.out.println("from: "+from);
        String user_name  = (String)request.getSession().getAttribute("user_name");
        List<Message> messages = messageService.listMessage(user_name, from, user_name);
        return JSONObject.toJSONString(messages);
    }
    @RequestMapping(value = "download")
    public void downLoad(HttpServletRequest request, HttpServletResponse response){
        String user_name = request.getParameter("user_name");
        System.out.print(user_name);
        //路径为  "/chatRoom/target/chatRoom/WEB-INF/download"   直接在target里加文件夹download就可以了
        String fileName = request.getSession().getServletContext().getRealPath("/WEB-INF/download")+"/history.txt";
        List<Message> messages = messageService.listAllMessage(user_name,user_name);
        try {
            //向history.txt写内容
            PrintWriter out = new PrintWriter(fileName);
            for(Message message:messages){
                out.println(message.getBody()+"    "+message.getTime());
            }
            out.close();
            //输入流
            InputStream is = new BufferedInputStream(new FileInputStream(new File(fileName)));
            String downFileName = user_name+".txt";
            downFileName = URLEncoder.encode(downFileName, "UTF-8");
            //设置文件下载头
            response.addHeader("Content-Disposition","attachment;filename="+downFileName);
            //设置文件ContentType类型， 会自动判断下载文件类型
            response.setContentType("multipart/form-data");
            BufferedOutputStream os = new BufferedOutputStream(response.getOutputStream());
            int len = 0;
            while ((len = is.read())!=-1){
                os.write(len);
                os.flush();
            }
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
