/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.andrii_loievets.haircutsystem.dao;

import com.epam.andrii_loievets.haircutsystem.entity.Client;
import java.util.List;

/**
 *
 * @author Andrii_Loievets
 */
public interface ClientDAO {

    Client findById(int id);

    Client findByEmail(String email);
    
    Client findByPhone(String phone);

    List<Client> findAll();

    Client insert(Client client);

    boolean deleteById(int id);
}
