/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epam.andrii_loievets.haircutsystem.service;

import com.epam.andrii_loievets.haircutsystem.entity.Cashier;

/**
 *
 * @author Tourist
 */
public interface CashierService {
    Cashier findById(int id);
}
