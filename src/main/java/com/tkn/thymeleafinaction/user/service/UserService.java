package com.tkn.thymeleafinaction.user.service;

import com.tkn.thymeleafinaction.user.model.User;
import org.hibernate.validator.constraints.EAN;

import java.util.List;

public interface UserService {


    /**
     *  添加或者修改
     * @param user
     * @return
     */
    User saveOrUpdateUser(User user);

    /**
     *  删除用户
     * @param id
     */
    void deleteUser(Long id);

    /**
     *  根据id获取用户
     * @param id
     * @return
     */
    User getUserById(Long id);

    /**
     *  获取所有用户
     * @return
     */
    List<User> listUser();
}
