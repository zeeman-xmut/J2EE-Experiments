package icu.zeeman.exps.mapper;

import icu.zeeman.exps.pojo.User;

/**
 * @author Zeeman Zhang
 */
public interface UserMapper {

    /**
     * @param user 一个 {@link User} 类型的实例对象
     * @return 新增的用户记录条数
     */
    int insert(User user);

    /**
     * @param uId 用户 ID
     * @return 一个由一条对应 ID 的用户记录映射而成的 {@link User} 类型的实例对象
     */
    User selectById(int uId);

    /**
     * @return 用户记录的总条数
     */
    int selectCounts();

    /**
     * @param user 一个 {@link User} 类型的实例对象
     * @return 受到影响而产生变更的用户记录条数
     */
    int update(User user);

    /**
     * @param uId 用户 ID
     * @return 被删除的用户记录条数
     */
    int deleteById(int uId);
}
