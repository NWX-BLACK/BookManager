import com.Nie.pojo.BookImage;
import com.Nie.service.BookImageServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookImageTest {

    @Test
    public void test(){
        ClassPathXmlApplicationContext contetx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        BookImageServiceImpl bookImageServiceImpl = (BookImageServiceImpl) contetx.getBean("bookImageServiceImpl");

        BookImage bookImage = bookImageServiceImpl.selectByBookImageId(1);
        System.out.println(bookImage.toString());
    }
}
