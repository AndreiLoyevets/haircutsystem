/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.andrii_loievets.haircutsystem.service;

import com.epam.andrii_loievets.haircutsystem.dao.ClientDAO;
import com.epam.andrii_loievets.haircutsystem.dao.ClientStatisticsDAO;
import com.epam.andrii_loievets.haircutsystem.entity.Client;
import com.epam.andrii_loievets.haircutsystem.entity.ClientStatistics;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 *
 * @author Tourist
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ClientServiceImpl implements ClientService {
    @EJB
    private ClientStatisticsDAO clientStatDAO;
    @EJB
    private ClientDAO clientDAO;
    @Resource
    private SessionContext context;
    private final int DISCOUNT = 5;
    private final int HAIRCUTS_FOR_DISCOUNT = 5;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public Client insert(Client client) {
        try {
            return clientDAO.insert(client);
        } catch (Exception e) {
            context.setRollbackOnly();
            throw e;
        }
    }

    @Override
    public List<Client> findAll() {
        return clientDAO.findAll();
    }

    @Override
    public Client findByEmail(String email) {
        return clientDAO.findByEmail(email);
    }
    
    @Override
    public Client findByPhone(String phone) {
        return clientDAO.findByPhone(phone);
    }

    @Override
    public List<Client> orderByEmail(List<Client> clients) {
        Collections.sort(clients,
                new Comparator<Client>() {

                    @Override
                    public int compare(Client o1, Client o2) {
                        return o1.getEmail().compareToIgnoreCase(o2.getEmail());
                    }
                });
        return clients;
    }
    
    @Override
    public ClientStatistics findClientStatById(int id) {
        return clientStatDAO.findById(id);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public ClientStatistics setDiscount(ClientStatistics clientStat) {
        clientStat.setDiscount(DISCOUNT);
        return clientStatDAO.update(clientStat);
    }

    @Override
    public boolean requiresDiscount(ClientStatistics clientStat) {
        return (clientStat.getDiscount() == 0 &&
                clientStat.getTotalHaircuts() >= HAIRCUTS_FOR_DISCOUNT);
    }
    
    @Override
    public Client findById(int id) {
        return clientDAO.findById(id);
    }
}
