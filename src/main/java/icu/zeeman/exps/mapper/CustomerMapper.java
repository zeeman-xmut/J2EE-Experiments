package icu.zeeman.exps.mapper;

import icu.zeeman.exps.pojo.Customer;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Zeeman Zhang
 */
public interface CustomerMapper {

    /**
     * @param customer 一个 {@link Customer} 类型的实例对象
     * @return 由符合条件的顾客记录映射而成的 {@link Customer} 类型的实例对象组成的 {@link List} 类型的集合
     */
    Customer selectByNameAndJobs(Customer customer);

    /**
     * @param customer 一个 {@link Customer} 类型的实例对象
     * @return 由符合条件的顾客记录映射而成的 {@link Customer} 类型的实例对象组成的 {@link List} 类型的集合
     */
    Customer selectByNameOrJobs(Customer customer);

    /**
     * @param array 一个由 {@link Integer} 类型的 {@code id} 组成的数组
     * @return 由符合条件的顾客记录映射而成的 {@link Customer} 类型的实例对象组成的 {@link List} 类型的集合
     */
    Customer selectByArray(Arrays array);

    /**
     * @param list 一个由 {@link Integer} 类型的 {@code id} 组成的 {@link List} 类型的集合
     * @return 由符合条件的顾客记录映射而成的 {@link Customer} 类型的实例对象组成的 {@link List} 类型的集合
     */
    Customer selectByList(List<Integer> list);

    /**
     * @param map 一个由 {@link Integer} 类型的 {@code id} 组成的 {@link Integer} 类型的集合和一个 {@link String} 类型的 {@code jobs} 属性组成的 {@link Map} 类型的集合
     * @return 由符合条件的顾客记录映射而成的 {@link Customer} 类型的实例对象组成的 {@link List} 类型的集合
     */
    Customer selectByMap(Map<String, Object> map);

    /**
     * @param customer customer 一个 {@link Customer} 类型的实例对象
     * @return 受到影响而产生变更的顾客记录条数
     */
    int updateCustomerBySet(Customer customer);
}
