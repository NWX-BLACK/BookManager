import com.Nie.dao.BookMapper;
import com.Nie.pojo.BookCondition;
import com.Nie.service.BookService;
import com.Nie.service.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookServiceImplTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        BookServiceImpl bookServiceImpl = context.getBean("bookServiceImpl", BookServiceImpl.class);
        BookCondition bookCondition = new BookCondition(null,null,null,null,"生活");
        System.out.println(bookServiceImpl.selectAll(bookCondition));
        System.out.println(bookCondition.toString());
    }
}
