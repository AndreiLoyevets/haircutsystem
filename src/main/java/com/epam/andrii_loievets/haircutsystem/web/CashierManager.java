/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epam.andrii_loievets.haircutsystem.web;

import com.epam.andrii_loievets.haircutsystem.entity.BasicUser;
import com.epam.andrii_loievets.haircutsystem.entity.Cashier;
import com.epam.andrii_loievets.haircutsystem.entity.RoleEnum;
import com.epam.andrii_loievets.haircutsystem.service.CashierService;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Tourist
 */
@ManagedBean(name = "cashierManager")
@SessionScoped
public class CashierManager {
    @ManagedProperty(value = "#{userManager}")
    private UserManager userManager;
    @EJB
    private CashierService cashierService;
    private Cashier cashier;

    public CashierService getCashierService() {
        return cashierService;
    }

    public void setCashierService(CashierService cashierService) {
        this.cashierService = cashierService;
    }
    
    public CashierManager() {}

    public UserManager getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public Cashier getCashier() {
        
        if (cashier == null) {
            BasicUser user = userManager.getUser();
            
            if (user != null && user.hasRole(RoleEnum.CASHIER)) {
                
                // update cashier
                cashier = cashierService.findById(user.getUserId());
            }
        }
        
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }
}