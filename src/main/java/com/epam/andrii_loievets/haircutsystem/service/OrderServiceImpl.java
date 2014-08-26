/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epam.andrii_loievets.haircutsystem.service;

import com.epam.andrii_loievets.haircutsystem.dao.OrderDAO;
import com.epam.andrii_loievets.haircutsystem.entity.ClientOrder;
import com.epam.andrii_loievets.haircutsystem.entity.ClientStatistics;
import com.epam.andrii_loievets.haircutsystem.entity.Haircut;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

/**
 *
 * @author Tourist
 */
@Stateless
public class OrderServiceImpl implements OrderService {
    @Resource
    private SessionContext context;
    @EJB
    private OrderDAO orderDAO;
    
    @Override
    public double calculatePrice(ClientStatistics clientStat, Haircut haircut) {
        return haircut.getPrice() * (100 - clientStat.getDiscount()) / 100.0;
    }

    @Override
    public ClientOrder insert(ClientOrder order) {
        try {
            return orderDAO.insert(order);
        } catch (Exception e) {
            context.setRollbackOnly();
            throw e;
        }
    }
}