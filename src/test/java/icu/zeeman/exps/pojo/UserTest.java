package icu.zeeman.exps.pojo;

import lombok.extern.java.Log;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Zeeman Zhang
 */
@Log
class UserTest {
    private static final String MYBATIS_CONFIG = "mybatis-config.xml";
    private static SqlSessionFactory sessionFactory;

    @BeforeAll
    static void initAll() throws IOException {
        try (InputStream resourceAsStream = Resources.getResourceAsStream(MYBATIS_CONFIG)) {
            SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
            sessionFactory = factoryBuilder.build(resourceAsStream);
        }
    }

    @Test
    void selectByIdTest() {
        try (SqlSession session = sessionFactory.openSession()) {
            User user = session.selectOne("selectById", 1);
            assertAll(
                () -> assertNotNull(user),
                () -> assertEquals("张三", user.getUName()),
                () -> assertEquals(20, user.getUAge())
            );
            log.info(user.toString());
        }
    }
}
