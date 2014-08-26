/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epam.andrii_loievets.haircutsystem.dao;

import com.epam.andrii_loievets.haircutsystem.entity.Haircut;
import java.util.List;

/**
 *
 * @author Tourist
 */
public interface HaircutDAO {
    Haircut findById(int id);

    Haircut findByName(String name);

    List<Haircut> findAll();
    
    List<Haircut> findMenAll();
    
    List<Haircut> findWomenAll();

    Haircut insert(Haircut haircut);

    Haircut update(Haircut haircut);

    boolean deleteById(int id);
}
