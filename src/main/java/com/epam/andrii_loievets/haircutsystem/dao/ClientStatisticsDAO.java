/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.andrii_loievets.haircutsystem.dao;

import com.epam.andrii_loievets.haircutsystem.entity.ClientStatistics;
import java.util.List;

/**
 *
 * @author Tourist
 */
public interface ClientStatisticsDAO {

    ClientStatistics findById(int id);

    List<ClientStatistics> findAll();

    ClientStatistics insert(ClientStatistics clientStat);

    ClientStatistics update(ClientStatistics clientStat);

    boolean deleteById(int id);
}
