package com.fwm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fwm.pojo.Group;
import com.fwm.pojo.Message;
import com.fwm.pojo.User;
import com.fwm.service.GroupService;
import com.fwm.service.MessageService;
import com.fwm.service.UserService;
import com.fwm.util.CaptchaUtil;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName AddController
 * @ProjectName chatRoom
 * @Description TODO
 * @Author 万民
 * @Date 2018/6/2 20:42
 * @Version 1.0
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    MessageService messageService;
    @Autowired
    GroupService groupService;

    @RequestMapping("/main")
    public ModelAndView main(HttpServletRequest request){
        String user_name = (String)request.getSession().getAttribute("user_name");
        ModelAndView mv = new ModelAndView();
        List<User> friends = userService.listFriends(user_name);
        List<Message> asks = messageService.listAsk(user_name);
        //List<Group> groups = groupService.getGroupsByUserName(user_name);
        //mv.addObject("groups", groups);
        mv.addObject("friends", friends);
        mv.addObject("asks", asks);
        mv.setViewName("main");
        return mv;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(User user, HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        String captcha = request.getParameter("captcha");
        if(captcha.equalsIgnoreCase((String )request.getSession().getAttribute("randomString"))){
            userService.addUser(user);
            request.getSession().setAttribute("user_name", user.getUser_name());
            mv.setViewName("redirect:/user/main");
        }
        else{
            mv.addObject("error", "验证码错误");
            mv.setViewName("signup");
        }
        return mv;
    }

    @RequestMapping("/login")
    public ModelAndView login(@RequestParam("email")String email, @RequestParam("password")String password,HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        User user = userService.selectUser(new User(email, password));
        if(user!=null){
            request.getSession().setAttribute("user_name", user.getUser_name());
            mv.setViewName("redirect:/user/main");
        }else{
            mv.addObject("error", "密码错误，请重新登录!");
            mv.setViewName("login");
        }
        return mv;
    }
    //restful中的参数有 . 会导致后面的数据被丢失
    @RequestMapping(value = "/ask/{friend_name:.+}",produces = "application/text;charset=utf-8")
    @ResponseBody
    public String askFriend(@PathVariable("friend_name")String friend_name,HttpServletRequest request){
        String user_name = (String)request.getSession().getAttribute("user_name");
        messageService.addAsk(new Message(user_name,user_name, friend_name,1));
        return "请求已发送给"+friend_name;
    }


    @RequestMapping(value = "/agree/{friend_id:.+}",produces = "application/text;charset=utf-8")
    @ResponseBody
    public String  agreeFriend(@PathVariable("friend_id")String friend_id, HttpServletRequest request){
        String user_name = (String)request.getSession().getAttribute("user_name");
        messageService.deleteAsk(friend_id, user_name);
        userService.addFriend(user_name, friend_id);
        return "添加"+friend_id+"成功";
    }
    @RequestMapping(value = "/refuse/{friend_id:.+}",produces = "application/text;charset=utf-8")
    @ResponseBody
    public void refuseFriend(@PathVariable("friend_id")String friend_id, HttpServletRequest request){
        String user_name = (String)request.getSession().getAttribute("user_name");
        messageService.deleteAsk(friend_id, user_name);
    }

    @RequestMapping(value = "/findUser",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String findUser(@RequestParam("user_name")String user_name){
        List<User> userList = userService.selectUserByName(user_name);
        String userJson = JSONObject.toJSONString(userList);
        return userJson;
    }

    @RequestMapping(value = "/addImpression")
    public ModelAndView addImpression(@RequestParam("impression")String impression,@RequestParam("user_name")String user_name){
        ModelAndView mv = new ModelAndView();
        if(!impression.equals("")){
            userService.addImpression(user_name, impression);
        }
        mv.setViewName("redirect:/user/main");
        return mv;
    }

    @RequestMapping(value = "/captcha")
    @ResponseBody
    public void captcha(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        CaptchaUtil.outputCaptcha(request, response);
    }
}
