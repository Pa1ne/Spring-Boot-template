package com.paine.spring.boot.template.spring_boot_template.repository;


import com.paine.spring.boot.template.spring_boot_template.entity.User;

import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityManager;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void addOrEditUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUserById(long id) {
        User user = entityManager.getReference(User.class, id);
        entityManager.remove(user);
    }
}