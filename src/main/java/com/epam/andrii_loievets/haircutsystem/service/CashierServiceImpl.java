/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epam.andrii_loievets.haircutsystem.service;

import com.epam.andrii_loievets.haircutsystem.dao.CashierDAO;
import com.epam.andrii_loievets.haircutsystem.entity.Cashier;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 *
 * @author Tourist
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class CashierServiceImpl implements CashierService {
    @EJB
    private CashierDAO cashierDAO;

    @Override
    public Cashier findById(int id) {
        return cashierDAO.findById(id);
    }
    
}
