/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.andrii_loievets.haircutsystem.dao;

import com.epam.andrii_loievets.haircutsystem.entity.Cashier;

/**
 *
 * @author Tourist
 */
public interface CashierDAO {

    Cashier findById(int id);
}
