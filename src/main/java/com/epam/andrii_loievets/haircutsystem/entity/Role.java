/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.andrii_loievets.haircutsystem.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Andrii_Loievets
 */
@Entity
@Table(name = "ROLE")
@NamedQueries({
    @NamedQuery(name = "Role.findByUserId",
            query = "SELECT r FROM Role r WHERE r.rolePK.userId = :user_id"),
})
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RolePK rolePK;
    
    public Role() {
    }

    public Role(RolePK rolePK) {
        this.rolePK = rolePK;
    }

    public Role(Integer userId, RoleEnum userRole) {
        this.rolePK = new RolePK(userId, userRole);
    }

    public RolePK getRolePK() {
        return rolePK;
    }

    public void setRolePK(RolePK rolePK) {
        this.rolePK = rolePK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolePK != null ? rolePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.rolePK == null && other.rolePK != null) || (this.rolePK != null && !this.rolePK.equals(other.rolePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epam.andrii_loievets.haircutsystem.entity.Role[ rolePK=" + rolePK + " ]";
    }
}