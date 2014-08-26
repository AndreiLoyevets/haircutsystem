/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.andrii_loievets.haircutsystem.dao;

import com.epam.andrii_loievets.haircutsystem.entity.GenderEnum;
import com.epam.andrii_loievets.haircutsystem.entity.Haircut;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Tourist
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class HaircutDAOImpl implements HaircutDAO {

    @PersistenceContext(unitName = "mainunit")
    private EntityManager em;

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public Haircut findById(int id) {
        return em.find(Haircut.class, id);
    }

    @Override
    public Haircut findByName(String name) {
        TypedQuery<Haircut> query = em.createNamedQuery("Haircut.findByName",
                Haircut.class);
        query.setParameter("name", name);

        List<Haircut> haircuts = query.getResultList();

        if (haircuts.isEmpty()) {
            return null;
        } else {
            return haircuts.get(0);
        }
    }

    @Override
    public List<Haircut> findAll() {
        TypedQuery<Haircut> query = em.createNamedQuery("Haircut.findAll",
                Haircut.class);

        return query.getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public Haircut insert(Haircut haircut) {
        em.persist(haircut);
        return haircut;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean deleteById(int id) {
        Haircut haircut = em.find(Haircut.class, id);

        if (haircut != null) {
            em.remove(haircut);
            return true;
        }

        return false;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public Haircut update(Haircut haircut) {
        return em.merge(haircut);
    }

    @Override
    public List<Haircut> findMenAll() {
        TypedQuery<Haircut> query = em.createNamedQuery("Haircut.findByGender",
                Haircut.class);

        query.setParameter("gender", GenderEnum.MALE);

        return query.getResultList();
    }

    @Override
    public List<Haircut> findWomenAll() {
        TypedQuery<Haircut> query = em.createNamedQuery("Haircut.findByGender",
                Haircut.class);

        query.setParameter("gender", GenderEnum.FEMALE);

        return query.getResultList();
    }
}
