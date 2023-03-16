package icu.zeeman.exps.mapper;

import icu.zeeman.exps.pojo.Student;

import java.util.List;

/**
 * @author Zeeman Zhang
 */
public interface StudentMapper {

    /**
     * @param student 一个 {@link Student} 类型的实例对象
     * @return 由符合条件的顾客记录映射而成的 {@link Student} 类型的实例对象组成的 {@link List} 类型的集合
     */
    Student selectByNameAndMajor(Student student);


    /**
     * @param list 一个由 {@link Integer} 类型的 {@code id} 组成的 {@link List} 类型的集合
     * @return 由符合条件的顾客记录映射而成的 {@link Student} 类型的实例对象组成的 {@link List} 类型的集合
     */
    Student selectByList(List<Integer> list);
}
