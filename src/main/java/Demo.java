import com.kafka.dao.UserDao;
import com.kafka.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

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
        System.out.println(userDao.findById(1));

        System.out.println(userDao.findByUser(new User(2, "PDD", 25, "上海")));

        var map = new HashMap<String, Object>();
        map.put("id", 2);
        map.put("username", "PDD");
        map.put("age", 25);
        map.put("address", "上海");
        System.out.println(userDao.findByMap(map));

        System.out.println(userDao.findByCondition(2, "PDD"));

        // userDao.insertUser(new User(3, "Clearlove", 30, "武汉"));
        // userDao.deleteUser(3);
        userDao.updateUser(new User(2, "Clearlove", 30, "武汉"));
        sqlSession.commit();
        // 释放资源
        sqlSession.close();
    }
}