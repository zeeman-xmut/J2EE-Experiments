package icu.zeeman.exps.mapper;

import icu.zeeman.exps.pojo.User;
import lombok.extern.java.Log;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Zeeman Zhang
 */
@Log
class UserMapperTest {
    private static final String MYBATIS_CONFIG = "mybatis-config.xml";
    private static SqlSessionFactory sessionFactory;
    private SqlSession session;
    private UserMapper userMapper;

    @BeforeAll
    static void initAll() throws IOException {
        try (InputStream resourceAsStream = Resources.getResourceAsStream(MYBATIS_CONFIG)) {
            SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
            sessionFactory = factoryBuilder.build(resourceAsStream);
        }
    }

    @BeforeEach
    void init() {
        session = sessionFactory.openSession();
        userMapper = session.getMapper(UserMapper.class);
    }

    @Test
    void insertTest() {
        User user = new User(4, "张子漠", 24);
        log.info(String.format("插入前: %s", user));

        int rowCounts = userMapper.insert(user);
        assertEquals(1, rowCounts);
        log.info(String.format("插入后: %s", user));
    }

    @Test
    void selectByIdTest() {
        User user = userMapper.selectById(1);
        assertAll(
            () -> assertNotNull(user),
            () -> assertEquals("张三", user.getUName()),
            () -> assertEquals(20, user.getUAge())
        );
        log.info(user.toString());
    }

    @Test
    void selectCountsTest() {
        int userCounts = userMapper.selectCounts();
        log.info(String.format("用户记录的总条数: %d", userCounts));
    }

    @Test
    void updateTest() {
        User user = new User(1, "张子漠", 24);

        int rowCounts = userMapper.update(user);
        User updatedUser = userMapper.selectById(1);
        assertAll(
            () -> assertEquals(1, rowCounts),
            () -> assertNotNull(updatedUser),
            () -> assertEquals("张子漠", updatedUser.getUName()),
            () -> assertEquals(24, updatedUser.getUAge())
        );
        log.info(updatedUser.toString());
    }

    @Test
    void deleteByIdTest() {
        int rowCounts = userMapper.deleteById(1);
        User deletedUser = userMapper.selectById(1);
        assertAll(() -> assertEquals(1, rowCounts), () -> assertNull(deletedUser));
    }

    @AfterEach
    void tearDown() {
        session.close();
    }
}
