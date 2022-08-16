import com.Nie.pojo.User;
import com.Nie.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserServiceImplTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserServiceImpl userServiceImpl = context.getBean("userServiceImpl", UserServiceImpl.class);
        System.out.println(userServiceImpl);

        List<User> users = userServiceImpl.queryAll();
        for (User user:users) {
            System.out.println(user.toString());
        }

        System.out.println(userServiceImpl.queryByUserName("").toString());
    }
}
