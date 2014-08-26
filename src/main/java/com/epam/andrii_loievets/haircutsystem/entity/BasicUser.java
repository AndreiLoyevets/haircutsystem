/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epam.andrii_loievets.haircutsystem.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Andrii_Loievets
 */
@Entity
@Table(name = "BASICUSER")
@NamedQueries({
    @NamedQuery(name = "BasicUser.findByLogin",
            query = "SELECT u FROM BasicUser u WHERE u.login = :login"),
    @NamedQuery(name = "BasicUser.findAll",
            query = "SELECT u FROM BasicUser u"),
})
public class BasicUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator="UserSeq")
    @SequenceGenerator(name="UserSeq",sequenceName="USER_SEQ", allocationSize=1) 
    @Column(name = "USER_ID")
    private Integer userId;
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "LOGIN")
    private String login;
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "PASSWORD")
    private String password;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="USER_ID", referencedColumnName="USER_ID", insertable = false, updatable = false)
    private List<Role> roles;
    
    public synchronized void addRole(RoleEnum role) {
        Role userRole = new Role(new RolePK(userId, role));
        
        if (roles == null) {
            roles = new ArrayList<>();
        }
        
        roles.add(userRole);
    }
    
    public boolean hasRole(RoleEnum role) {
        if (roles != null) {
            for (Role r : roles) {
                if (r.rolePK.getUserRole() == role) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public BasicUser() {
    }

    public BasicUser(Integer userId) {
        this.userId = userId;
    }

    public BasicUser(Integer userId, String login, String password) {
        this.userId = userId;
        this.login = login;
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (login != null ? login.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BasicUser)) {
            return false;
        }
        BasicUser other = (BasicUser) object;
        if ((this.login == null && other.login != null) || (this.login != null && !this.login.equals(other.login))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epam.andrii_loievets.haircutsystem.entity.BasicUser[ login=" + login + " ]";
    }
}
