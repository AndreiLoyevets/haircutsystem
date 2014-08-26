/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.andrii_loievets.haircutsystem.dao;

import com.epam.andrii_loievets.haircutsystem.entity.BasicUser;
import java.util.List;

/**
 *
 * @author Andrii_Loievets
 */
public interface BasicUserDAO {

    BasicUser findById(int id);

    BasicUser findByLogin(String login);

    List<BasicUser> findAll();

    BasicUser insert(BasicUser user);

    BasicUser update(BasicUser user);

    boolean deleteById(int id);
}
