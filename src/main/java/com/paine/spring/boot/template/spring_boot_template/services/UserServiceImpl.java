package com.paine.spring.boot.template.spring_boot_template.services;


import com.paine.spring.boot.template.spring_boot_template.repository.UserDao;
import com.paine.spring.boot.template.spring_boot_template.entity.User;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void deleteUserById(long id) {
        userDao.deleteUserById(id);
    }

    @Override
    @Transactional
    public void addOrEditUser(User user) {
        userDao.addOrEditUser(user);
    }

    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
