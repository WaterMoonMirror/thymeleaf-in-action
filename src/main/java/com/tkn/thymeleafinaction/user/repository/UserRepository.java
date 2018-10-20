package com.tkn.thymeleafinaction.user.repository;

import com.tkn.thymeleafinaction.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    @Override
    void deleteById(Long aLong);
}
