/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.andrii_loievets.haircutsystem.dao;

import com.epam.andrii_loievets.haircutsystem.entity.BasicUser;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Andrii_Loievets
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class BasicUserDAOImpl implements BasicUserDAO {

    @PersistenceContext(unitName = "mainunit")
    private EntityManager em;

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public BasicUser findById(int id) {
        return em.find(BasicUser.class, id);
    }

    @Override
    public BasicUser findByLogin(String login) {
        TypedQuery<BasicUser> query = em.createNamedQuery("BasicUser.findByLogin",
                BasicUser.class);
        query.setParameter("login", login);

        List<BasicUser> users = query.getResultList();

        if (users.isEmpty()) {
            return null;
        } else {
            return users.get(0);
        }
    }

    @Override
    public List<BasicUser> findAll() {
        TypedQuery<BasicUser> query = em.createNamedQuery("BasicUser.findAll",
                BasicUser.class);

        return query.getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public BasicUser insert(BasicUser user) {
        em.persist(user);
        return user;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean deleteById(int id) {
        BasicUser user = em.find(BasicUser.class, id);

        if (user != null) {
            em.remove(user);
            return true;
        }

        return false;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public BasicUser update(BasicUser user) {
        return em.merge(user);
    }
}
