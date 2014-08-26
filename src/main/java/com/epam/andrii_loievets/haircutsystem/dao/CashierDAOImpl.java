/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.andrii_loievets.haircutsystem.dao;

import com.epam.andrii_loievets.haircutsystem.entity.Cashier;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tourist
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class CashierDAOImpl implements CashierDAO {

    @PersistenceContext(unitName = "mainunit")
    private EntityManager em;

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public Cashier findById(int id) {
        return em.find(Cashier.class, id);
    }
}
