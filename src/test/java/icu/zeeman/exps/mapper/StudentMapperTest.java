package icu.zeeman.exps.mapper;

import icu.zeeman.exps.pojo.Student;
import icu.zeeman.exps.util.MyBatisUtils;
import lombok.extern.java.Log;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Zeeman Zhang
 */
@Log
class StudentMapperTest {
    private SqlSession session;

    @BeforeEach
    void init() {
        session = MyBatisUtils.getSession();
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
