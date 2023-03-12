package icu.zeeman.exps.mapper;

import icu.zeeman.exps.pojo.Employee;
import icu.zeeman.exps.util.MyBatisUtils;
import lombok.extern.java.Log;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Zeeman Zhang
 */
@Log
class EmployeeMapperTest {
    private SqlSession session;
    private EmployeeMapper employeeMapper;

    @BeforeEach
    void init() {
        session = MyBatisUtils.getSession();
        employeeMapper = session.getMapper(EmployeeMapper.class);
    }

    @Test
    void insertTest() {
        Employee employee = new Employee(4, "张子漠", 24, null);
        log.info(String.format("插入前: %s", employee));

        int rowCounts = employeeMapper.insert(employee);
        assertEquals(1, rowCounts);
        log.info(String.format("插入后: %s", employee));
    }

    @Test
    void selectByIdTest() {
        Employee employee = employeeMapper.selectById(1);
        assertAll(
            () -> assertNotNull(employee),
            () -> assertEquals("张三", employee.getName()),
            () -> assertEquals(20, employee.getAge()),
            () -> assertEquals("员工", employee.getPosition())
        );
        log.info(employee.toString());
    }

    @Test
    void updateTest() {
        Employee employee = new Employee(1, "张子漠", 24, null);

        int rowCounts = employeeMapper.update(employee);
        Employee updatedEmployee = employeeMapper.selectById(1);
        assertAll(
            () -> assertEquals(1, rowCounts),
            () -> assertNotNull(updatedEmployee),
            () -> assertEquals("张子漠", updatedEmployee.getName()),
            () -> assertEquals(24, updatedEmployee.getAge()),
            () -> assertNull(updatedEmployee.getPosition())
        );
        log.info(updatedEmployee.toString());
    }

    @Test
    void deleteByIdTest() {
        int rowCounts = employeeMapper.deleteById(1);
        Employee deletedEmployee = employeeMapper.selectById(1);
        assertAll(() -> assertEquals(1, rowCounts), () -> assertNull(deletedEmployee));
    }

    @AfterEach
    void tearDown() {
        session.close();
    }
}
