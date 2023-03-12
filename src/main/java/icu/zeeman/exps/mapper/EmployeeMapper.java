package icu.zeeman.exps.mapper;

import icu.zeeman.exps.pojo.Employee;

/**
 * @author Zeeman Zhang
 */
public interface EmployeeMapper {

    /**
     * @param employee 一个 {@link Employee} 类型的实例对象
     * @return 新增的员工记录条数
     */
    int insert(Employee employee);

    /**
     * @param id 员工 ID
     * @return 一个由一条对应 ID 的员工记录映射而成的 {@link Employee} 类型的实例对象
     */
    Employee selectById(int id);

    /**
     * @param employee 一个 {@link Employee} 类型的实例对象
     * @return 受到影响而产生变更的员工记录条数
     */
    int update(Employee employee);

    /**
     * @param id 员工 ID
     * @return 被删除的用户记录条数
     */
    int deleteById(int id);
}
