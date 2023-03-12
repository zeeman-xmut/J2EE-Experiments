package icu.zeeman.exps.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Zeeman Zhang
 */
public class MyBatisUtils {
    private static final String MYBATIS_CONFIG = "mybatis-config.xml";
    private static SqlSessionFactory sessionFactory;

    static {
        try (InputStream resourceAsStream = Resources.getResourceAsStream(MYBATIS_CONFIG)) {
            SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
            sessionFactory = factoryBuilder.build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSession() {
        return sessionFactory.openSession();
    }
}
