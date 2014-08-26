/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epam.andrii_loievets.haircutsystem.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Andrii_Loievets
 */
@Embeddable
public class RolePK implements Serializable {
    @NotNull
    @Column(name = "USER_ID")
    private Integer userId;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "USER_ROLE")
    private RoleEnum userRole;

    public RolePK() {
    }

    public RolePK(Integer userId, RoleEnum userRole) {
        this.userId = userId;
        this.userRole = userRole;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public RoleEnum getUserRole() {
        return userRole;
    }

    public void setUserRole(RoleEnum userRole) {
        this.userRole = userRole;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        hash += (userRole != null ? userRole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolePK)) {
            return false;
        }
        RolePK other = (RolePK) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        if ((this.userRole == null) || (this.userRole != other.userRole)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epam.andrii_loievets.haircutsystem.entity.RolePK[ userId=" + userId + ", userRole=" + userRole + " ]";
    }
}
