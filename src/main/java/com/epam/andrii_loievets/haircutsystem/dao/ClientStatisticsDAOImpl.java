/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epam.andrii_loievets.haircutsystem.dao;

import com.epam.andrii_loievets.haircutsystem.entity.ClientStatistics;
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
public class ClientStatisticsDAOImpl implements ClientStatisticsDAO {
    @PersistenceContext(unitName = "mainunit")
    private EntityManager em;

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public ClientStatistics findById(int id) {
        return em.find(ClientStatistics.class, id);
    }

    @Override
    public List<ClientStatistics> findAll() {
         TypedQuery<ClientStatistics> query = em.createNamedQuery("ClientStatistics.findAll",
                ClientStatistics.class);

        return query.getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public ClientStatistics insert(ClientStatistics clientStat) {
        clientStat.setClientId(clientStat.getClient().getUserId());
        em.persist(clientStat);
        
        return clientStat;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean deleteById(int id) {
        ClientStatistics clientStat = em.find(ClientStatistics.class, id);
       
       if (clientStat != null) {
           em.remove(clientStat);
           return true;
       }
       
       return false;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public ClientStatistics update(ClientStatistics clientStat) {
        return em.merge(clientStat);
    }
}