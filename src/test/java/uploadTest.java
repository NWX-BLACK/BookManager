import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class uploadTest {

    @Test
    public void test(){
        File file = new File("C:\\Users\\Administrator\\Desktop\\JAVA学习笔记\\网上项目\\JavaProgram-master\\BookManage\\web\\bookcover\\103.jpg");
        Path path = Paths.get("E:\\IDEA\\BookManager\\src\\main\\webapp\\static\\image\\book", file.getName());
        File tempFile = new File(path.toString());

        //判断图片是否已存在
        if (!tempFile.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                Files.copy(fileInputStream, path);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("upLoad Image Success");
        }
    }
}
