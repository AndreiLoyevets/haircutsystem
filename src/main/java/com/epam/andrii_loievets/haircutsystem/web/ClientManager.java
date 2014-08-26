/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.andrii_loievets.haircutsystem.web;

import com.epam.andrii_loievets.haircutsystem.entity.BasicUser;
import com.epam.andrii_loievets.haircutsystem.entity.Client;
import com.epam.andrii_loievets.haircutsystem.entity.ClientStatistics;
import com.epam.andrii_loievets.haircutsystem.entity.RoleEnum;
import com.epam.andrii_loievets.haircutsystem.service.ClientService;
import com.epam.andrii_loievets.haircutsystem.web.transfer.UserTransfer;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Tourist
 */
@ManagedBean(name = "clientManager")
@SessionScoped
public class ClientManager implements Serializable {

    @ManagedProperty(value = "#{userManager}")
    private UserManager userManager;
    @EJB
    private ClientService clientService;
    private Client client;
    private ClientStatistics clientStat;
    private List<Client> clients;

    public ClientStatistics getClientStat() {
        return clientStat;
    }

    public void setClientStat(ClientStatistics clientStat) {
        this.clientStat = clientStat;
    }

    public ClientService getClientService() {
        return clientService;
    }

    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public ClientManager() {
    }

    public String register(UserTransfer user, Client client) {
        
        // compare passwords
        if (!user.passwordsMatch()) {
            FacesContext.getCurrentInstance().addMessage(
                    "registrationform:regerrors",
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Passwords don't match", null));
            
            return "user-registration";
        }
        
        userManager.register(user);

        // find out the result of registration
        BasicUser registeredUser = userManager.getUser();

        if (registeredUser != null) {

            // user registered successfully
            client.setBasicUser(registeredUser);
            this.client = clientService.insert(client);

            return "mens-collection";
        }

        return "user-registration";
    }

    public List<Client> findAllClients() {
        BasicUser user = userManager.getUser();

        if (user != null && user.hasRole(RoleEnum.CASHIER)) {
            if (clients == null) {
                clients = clientService.orderByEmail(clientService.findAll());
            }
            return clients;
        } else {
            return null;
        }
    }

    public void chooseClient(Client client) {
        clientStat = clientService.findClientStatById(client.getUserId());
        setClient(client);
    }

    public Client updateClient() {
        BasicUser user = userManager.getUser();

        if (user == null) {
            client = null;
        } else {
            client = clientService.findById(user.getUserId());
        }

        return client;
    }

    public void uniqueEmailCheck(FacesContext context, UIComponent component,
            Object value) throws ValidatorException {

        String email = value.toString().trim();

        if (clientService.findByEmail(email) != null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Email already in use", null);
            throw new ValidatorException(message);
        }
    }

    public void uniquePhoneCheck(FacesContext context, UIComponent component,
            Object value) throws ValidatorException {

        String phone = value.toString().trim();

        if (phone.length() == 0) {
            return;
        }
        
        if (clientService.findByPhone(phone) != null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Phone already in use", null);
            throw new ValidatorException(message);
        }
    }
}
