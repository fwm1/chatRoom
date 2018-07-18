
import com.fwm.pojo.User;
import com.fwm.service.GroupService;
import com.fwm.service.MessageService;
import com.fwm.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @ClassName MybatisTest
 * @ProjectName chatRoom
 * @Description TODO
 * @Author 万民
 * @Date 2018/6/2 8:10
 * @Version 1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {
    @Autowired
    MessageService messageService;
    @Autowired
    UserService userService;
    @Autowired
    GroupService groupService;
    @Test
    public void addTest() {
        //userService.addUser(new User("周进","fwm123","男",20,"zj@qq.com","江西南昌"));
        //userService.addFriend("冯万民", "周进");
        //messageService.addMessage(new Message("冯万民", "您好","冯万民","周进"));
        //messageService.deleteAsk("冯万民");
        userService.addImpression("冯万民1", "Junius");
    }
}
