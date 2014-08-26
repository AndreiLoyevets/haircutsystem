/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.andrii_loievets.haircutsystem.web;

import com.epam.andrii_loievets.haircutsystem.entity.BasicUser;
import com.epam.andrii_loievets.haircutsystem.entity.RoleEnum;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author Andrii_Loievets
 */
@ManagedBean(name = "menuManager")
@SessionScoped
public class MenuManager {
    private MenuModel model;

    public MenuModel getModel() {
        return model;
    }

    public MenuManager() {
    }

    @PostConstruct
    public void init() {
        refresh(null);
    }

    public final void refresh(UserManager userManager) {
        model = new DefaultMenuModel();

        DefaultMenuItem mensItem = new DefaultMenuItem();
        mensItem.setValue("Men's Collection");
        mensItem.setOutcome("mens-collection");
        model.addElement(mensItem);

        DefaultMenuItem womensItem = new DefaultMenuItem();
        womensItem.setValue("Women's Collection");
        womensItem.setOutcome("womens-collection");
        model.addElement(womensItem);

        if (userManager != null && userManager.isLoggedIn()) {
            BasicUser user = userManager.getUser();

            if (user.hasRole(RoleEnum.CLIENT)) {
                DefaultMenuItem clientItem = new DefaultMenuItem();
                clientItem.setValue("Personal");
                clientItem.setOutcome("client");
                model.addElement(clientItem);
            }

            if (user.hasRole(RoleEnum.CASHIER)) {
                DefaultMenuItem cashierItem = new DefaultMenuItem();
                cashierItem.setValue("Cashier");
                cashierItem.setOutcome("cashier");
                model.addElement(cashierItem);
            }

            if (user.hasRole(RoleEnum.ADMIN)) {
                DefaultMenuItem adminItem = new DefaultMenuItem();
                adminItem.setValue("Admin");
                adminItem.setOutcome("admin");
                model.addElement(adminItem);
            }
        }
    }
}