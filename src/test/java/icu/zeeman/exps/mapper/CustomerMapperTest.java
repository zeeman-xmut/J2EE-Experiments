package icu.zeeman.exps.mapper;

import icu.zeeman.exps.pojo.Customer;
import icu.zeeman.exps.util.MyBatisUtils;
import lombok.extern.java.Log;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Zeeman Zhang
 */
@Log
class CustomerMapperTest {
    private SqlSession session;

    @BeforeEach
    void init() {
        session = MyBatisUtils.getSession();
    }

    @Test
    void selectByNameAndJobsTest() {
        Customer customer = new Customer();
        customer.setUsername("jack");
        customer.setJobs("teacher");

        List<Customer> customers = session.selectList(
            "icu.zeeman.exps.mapper.CustomerMapper.selectByNameAndJobs",
            customer
        );
        assertNotNull(customers);
        customers.forEach(c -> log.info(c.toString()));
    }

    @Test
    void selectByNameOrJobsTest() {
        Customer customer = new Customer();
        customer.setUsername("tom");
        customer.setJobs("teacher");

        List<Customer> customers = session.selectList(
            "icu.zeeman.exps.mapper.CustomerMapper.selectByNameOrJobs",
            customer
        );
        assertNotNull(customers);
        customers.forEach(c -> log.info(c.toString()));
    }

    @Test
    void selectByArrayTest() {
        Integer[] ids = { 1, 3 };

        List<Customer> customers = session.selectList("icu.zeeman.exps.mapper.CustomerMapper.selectByArray", ids);
        assertNotNull(customers);
        customers.forEach(c -> log.info(c.toString()));
    }

    @Test
    void selectByListTest() {
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);

        List<Customer> customers = session.selectList("icu.zeeman.exps.mapper.CustomerMapper.selectByList", ids);
        assertNotNull(customers);
        customers.forEach(c -> log.info(c.toString()));
    }

    @Test
    void selectByMapTest() {
        List<Integer> ids = new ArrayList<>();
        ids.add(2);
        ids.add(3);
        Map<String, Object> map = new HashMap<>();
        map.put("ids", ids);
        map.put("jobs", "student");

        List<Customer> customers = session.selectList("icu.zeeman.exps.mapper.CustomerMapper.selectByMap", map);
        assertNotNull(customers);
        customers.forEach(c -> log.info(c.toString()));
    }

    @Test
    void updateCustomerBySetTest() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setUsername("张子漠");
        customer.setJobs("student");
        customer.setPhone("18649689865");

        int rows = session.update("icu.zeeman.exps.mapper.CustomerMapper.updateCustomerBySet", customer);
        assertEquals(1, rows);
        log.info("更新成功");
    }

    @AfterEach
    void tearDown() {
        session.close();
    }
}
