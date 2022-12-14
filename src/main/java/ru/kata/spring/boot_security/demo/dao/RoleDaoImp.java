package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Role;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class RoleDaoImp implements RoleDAO {

    @PersistenceContext()
    EntityManager entityManager;

    @Override
    public List allRole() {
        return entityManager.createQuery("from Role").getResultList();
    }

    @Override
    public Role findRoleById(Long id) throws NoSuchElementException {
        return entityManager.find(Role.class,id);
    }

    @Override
    public void addRole(Role role) {
        entityManager.persist(role);
    }

}
