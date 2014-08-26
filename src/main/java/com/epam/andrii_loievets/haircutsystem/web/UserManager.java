/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.andrii_loievets.haircutsystem.web;

import com.epam.andrii_loievets.haircutsystem.entity.BasicUser;
import com.epam.andrii_loievets.haircutsystem.entity.RoleEnum;
import com.epam.andrii_loievets.haircutsystem.service.UserService;
import com.epam.andrii_loievets.haircutsystem.web.transfer.UserTransfer;
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
 * @author Andrii_Loievets
 */
@ManagedBean(name = "userManager")
@SessionScoped
public class UserManager {

    private BasicUser user;
    private boolean loggedIn;
    @EJB
    private UserService userService;
    @ManagedProperty(value = "#{menuManager}")
    private MenuManager menuManager;

    public BasicUser getUser() {
        return user;
    }

    public void setUser(BasicUser user) {
        this.user = user;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setMenuManager(MenuManager menuManager) {
        this.menuManager = menuManager;
    }

    public String login(UserTransfer user) {
        BasicUser persistedUser = userService.findByLogin(user.getLogin());

        if (persistedUser != null
                && userService.comparePasswords(user, persistedUser)) {

            // login successful
            this.user = persistedUser;
            loggedIn = true;
            menuManager.refresh(this);

            return "mens-collection";
        } else {
            FacesContext.getCurrentInstance().addMessage("loginform:userauthent",
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Invalid login or password", null));

            return "login";
        }
    }

    public String logout() {

        // close the session and redirect to another page to kill session beans
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        
        return "/mens-collection.xhtml?faces-redirect=true";
    }

    public String register(UserTransfer user) {
        
        // double check if user exists
        BasicUser persistedUser = userService.findByLogin(user.getLogin());

        if (persistedUser == null) {

            // user with such login not found
            BasicUser newUser = new BasicUser(null, user.getLogin(),
                    user.getPassword());
            userService.insert(newUser);
            userService.addRole(newUser, RoleEnum.CLIENT);

            // login
            this.user = newUser;
            loggedIn = true;
            menuManager.refresh(this);
            
            return "mens-collection";

        }

        return "user-registration";
    }
    
    public void uniqueLoginCheck(FacesContext context, UIComponent component,
            Object value) throws ValidatorException {
        
        String login = value.toString().trim();
        
        if (userService.findByLogin(login) != null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "User already exists", null);
            throw new ValidatorException(message);
        }
    }
}
