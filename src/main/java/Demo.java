import com.kafka.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Demo {
    public static void main(String[] args) throws IOException {
        // 定义mybatis配置文件的路径
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取UserDao实现类对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        // 调用方法测试
        System.out.println(userDao.findAll());
        // 释放资源
        sqlSession.close();
    }
}