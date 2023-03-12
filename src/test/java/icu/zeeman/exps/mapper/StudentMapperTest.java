package icu.zeeman.exps.mapper;

import icu.zeeman.exps.pojo.Student;
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
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Zeeman Zhang
 */
@Log
class StudentMapperTest {
    private static final String MYBATIS_CONFIG = "mybatis-config.xml";
    private static SqlSessionFactory sessionFactory;
    private SqlSession session;

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
    }

    @Test
    void selectAllTest() {
        List<Student> allStudents = session.selectList("icu.zeeman.exps.mapper.StudentMapper.selectAll");
        assertNotNull(allStudents);
        for (Student student : allStudents) {
            log.info(student.toString());
        }
    }

    @AfterEach
    void tearDown() {
        session.close();
    }
}
