/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.andrii_loievets.haircutsystem.service;

import com.epam.andrii_loievets.haircutsystem.entity.BasicUser;
import com.epam.andrii_loievets.haircutsystem.entity.RoleEnum;

/**
 *
 * @author Andrii_Loievets
 */
public interface UserService {

    BasicUser findByLogin(String login);

    BasicUser insert(BasicUser user);

    void addRole(BasicUser user, RoleEnum role);
    
    boolean comparePasswords(BasicUser user1, BasicUser user2);
}
