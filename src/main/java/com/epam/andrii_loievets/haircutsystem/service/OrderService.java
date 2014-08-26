/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.andrii_loievets.haircutsystem.service;

import com.epam.andrii_loievets.haircutsystem.entity.ClientOrder;
import com.epam.andrii_loievets.haircutsystem.entity.ClientStatistics;
import com.epam.andrii_loievets.haircutsystem.entity.Haircut;

/**
 *
 * @author Tourist
 */
public interface OrderService {

    double calculatePrice(ClientStatistics clientStat, Haircut haircut);

    ClientOrder insert(ClientOrder order);
}
