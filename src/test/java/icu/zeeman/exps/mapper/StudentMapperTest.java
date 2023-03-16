package icu.zeeman.exps.mapper;

import icu.zeeman.exps.pojo.Student;
import icu.zeeman.exps.util.MyBatisUtils;
import lombok.extern.java.Log;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
    void selectByNameAndMajorTest() {
        Student student = new Student();
        student.setName("张三");
        student.setMajor("英语");

        List<Student> students = session.selectList(
            "icu.zeeman.exps.mapper.StudentMapper.selectByNameAndMajor",
            student
        );
        assertNotNull(students);
        students.forEach(s -> log.info(s.toString()));
    }

    @Test
    void selectByListTest() {
        List<Integer> ids = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            ids.add(i);
        }

        List<Student> students = session.selectList("icu.zeeman.exps.mapper.StudentMapper.selectByList", ids);
        assertNotNull(students);
        students.forEach(s -> log.info(s.toString()));
    }

    @AfterEach
    void tearDown() {
        session.close();
    }
}
