/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epam.andrii_loievets.haircutsystem.service;

import com.epam.andrii_loievets.haircutsystem.dao.BasicUserDAO;
import com.epam.andrii_loievets.haircutsystem.entity.BasicUser;
import com.epam.andrii_loievets.haircutsystem.entity.RoleEnum;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 *
 * @author Andrii_Loievets
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class UserServiceImpl implements UserService {
    @EJB
    private BasicUserDAO userDAO;

    @Override
    public BasicUser findByLogin(String login) {
        return userDAO.findByLogin(login);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public BasicUser insert(BasicUser user) {
        return userDAO.insert(user);
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public void addRole(BasicUser user, RoleEnum role) {
        user.addRole(role);
        userDAO.update(user);
    }
    
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    @Override
    public boolean comparePasswords(BasicUser user1, BasicUser user2) {
        return user1 != null && user1.getPassword().equals(user2.getPassword());
    }
}
