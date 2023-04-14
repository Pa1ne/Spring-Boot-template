package com.paine.spring.boot.template.spring_boot_template.repository;


import com.paine.spring.boot.template.spring_boot_template.entity.User;

import java.util.List;


public interface UserDao {
    List<User> getAllUsers();

    void addOrEditUser(User user);

    User getUserById(long id);

    void deleteUserById(long id);
}
