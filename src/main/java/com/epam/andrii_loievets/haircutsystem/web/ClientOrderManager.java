/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.andrii_loievets.haircutsystem.web;

import com.epam.andrii_loievets.haircutsystem.entity.ClientOrder;
import com.epam.andrii_loievets.haircutsystem.entity.ClientStatistics;
import com.epam.andrii_loievets.haircutsystem.service.OrderService;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Tourist
 */
@ManagedBean(name = "ordersManag")
@SessionScoped
public class ClientOrderManager {

    @ManagedProperty(value = "#{clientManager}")
    private ClientManager clientManager;
    @ManagedProperty(value = "#{haircutsManager}")
    private HaircutsManager haircutsManager;
    @ManagedProperty(value = "#{cashierManager}")
    private CashierManager cashierManager;
    @EJB
    private OrderService orderService;
    private double price;

    public ClientOrderManager() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ClientManager getClientManager() {
        return clientManager;
    }

    public void setClientManager(ClientManager clientManager) {
        this.clientManager = clientManager;
    }

    public HaircutsManager getHaircutsManager() {
        return haircutsManager;
    }

    public CashierManager getCashierManager() {
        return cashierManager;
    }

    public void setCashierManager(CashierManager cashierManager) {
        this.cashierManager = cashierManager;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public void setHaircutsManager(HaircutsManager haircutsManager) {
        this.haircutsManager = haircutsManager;
    }

    public double updatePrice() {
        price = orderService.calculatePrice(clientManager.getClientStat(),
                haircutsManager.getCurrentHaircut());

        return price;
    }

    public void createOrder() {
        ClientOrder order = new ClientOrder();

        updatePrice();

        order.setClientStat(clientManager.getClientStat());
        order.setHaircut(haircutsManager.getCurrentHaircut());
        order.setCashier(cashierManager.getCashier());
        order.setDepartment(cashierManager.getCashier().getDepartment());
        order.setOrderPrice(price);
        order.setOrderDate(new Date());

        orderService.insert(order);

        // update discount
        if (clientManager.getClientService().requiresDiscount(clientManager.getClientStat())) {
            ClientStatistics clientStat = clientManager.getClientStat();
            clientStat = clientManager.getClientService().setDiscount(clientStat);
            clientManager.setClientStat(clientStat);
        }
    }
}