import com.Nie.dao.BookMapper;
import com.Nie.pojo.BookCondition;
import com.Nie.service.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class BookMapperTest {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
        BookMapper bookServiceImpl = context.getBean("bookMapperImpl", BookMapper.class);
        BookCondition bookCondition = new BookCondition(null,null,null,null,"生活");
        System.out.println(bookServiceImpl.selectAll(bookCondition));

    }
}
