/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epam.andrii_loievets.haircutsystem.service;

import com.epam.andrii_loievets.haircutsystem.dao.HaircutDAO;
import com.epam.andrii_loievets.haircutsystem.entity.Haircut;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 *
 * @author Tourist
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class HaircutServiceImpl implements HaircutService {
    @EJB
    private HaircutDAO haircutDAO;

    @Override
    public List<Haircut> findMenAll() {
        return haircutDAO.findMenAll();
    }

    @Override
    public List<Haircut> findWomenAll() {
        return haircutDAO.findWomenAll();
    }

    @Override
    public List<Haircut> findAll() {
        return haircutDAO.findAll();
    }

    @Override
    public Haircut findById(int id) {
        return haircutDAO.findById(id);
    }
}
