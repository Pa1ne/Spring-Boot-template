package com.paine.spring.boot.template.spring_boot_template.services;


import com.paine.spring.boot.template.spring_boot_template.entity.User;

import java.util.List;


public interface UserService {
    List<User> getAllUsers();

    User getUserById(long id);

    void deleteUserById(long id);

    void addOrEditUser(User user);
}