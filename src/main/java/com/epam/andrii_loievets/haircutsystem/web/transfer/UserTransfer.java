/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epam.andrii_loievets.haircutsystem.web.transfer;

import com.epam.andrii_loievets.haircutsystem.entity.BasicUser;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Tourist
 */
@ManagedBean(name = "userBean")
@RequestScoped
public class UserTransfer extends BasicUser {
    private String confirmPassword;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    
    public boolean passwordsMatch() {
        return confirmPassword != null && confirmPassword.equals(getPassword());
    }
}
