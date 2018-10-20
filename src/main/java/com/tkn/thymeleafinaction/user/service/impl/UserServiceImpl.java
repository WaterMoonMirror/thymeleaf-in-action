package com.tkn.thymeleafinaction.user.service.impl;

import com.tkn.thymeleafinaction.user.model.User;
import com.tkn.thymeleafinaction.user.repository.UserRepository;
import com.tkn.thymeleafinaction.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    /**
     * 添加或者修改
     *
     * @param user
     * @return
     */
    @Override
    public User saveOrUpdateUser(User user) {
        return userRepository.save(user);
    }

    /**
     * 删除用户
     *
     * @param id
     */
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    /**
     * 根据id获取用户
     *
     * @param id
     * @return
     */
    @Override
    public User getUserById(Long id) {
        return userRepository.getOne(id);
    }

    /**
     * 获取所有用户
     *
     * @return
     */
    @Override
    public List<User> listUser() {
        return userRepository.findAll();
    }
}
