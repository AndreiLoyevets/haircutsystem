/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epam.andrii_loievets.haircutsystem.service;

import com.epam.andrii_loievets.haircutsystem.entity.Haircut;
import java.util.List;

/**
 *
 * @author Tourist
 */
public interface HaircutService {
    List<Haircut> findMenAll();
    List<Haircut> findWomenAll();
    List<Haircut> findAll();
    Haircut findById(int id);
}
