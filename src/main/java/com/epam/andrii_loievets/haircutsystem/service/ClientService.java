/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.andrii_loievets.haircutsystem.service;

import com.epam.andrii_loievets.haircutsystem.entity.Client;
import com.epam.andrii_loievets.haircutsystem.entity.ClientStatistics;
import java.util.List;

/**
 *
 * @author Tourist
 */
public interface ClientService {
    
    Client findById(int id);

    Client insert(Client client);

    List<Client> findAll();

    Client findByEmail(String email);
    
    Client findByPhone(String phone);

    List<Client> orderByEmail(List<Client> clients);

    ClientStatistics findClientStatById(int id);
    
    ClientStatistics setDiscount(ClientStatistics clientStat);
    
    boolean requiresDiscount(ClientStatistics clientStat);
}
