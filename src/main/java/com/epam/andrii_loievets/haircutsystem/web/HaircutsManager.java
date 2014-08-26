/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epam.andrii_loievets.haircutsystem.web;

import com.epam.andrii_loievets.haircutsystem.entity.Haircut;
import com.epam.andrii_loievets.haircutsystem.service.HaircutService;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Tourist
 */
@ManagedBean(name = "haircutsManager")
@SessionScoped
public class HaircutsManager {
    @EJB
    private HaircutService haircutService;
    private Haircut currentHaircut;
    private List<Haircut> mensHaircuts;
    private List<Haircut> womensHaircuts;

    public HaircutService getHaircutService() {
        return haircutService;
    }

    public void setHaircutService(HaircutService haircutService) {
        this.haircutService = haircutService;
    }

    public Haircut getCurrentHaircut() {
        return currentHaircut;
    }

    public void setCurrentHaircut(Haircut currentHaircut) {
        this.currentHaircut = currentHaircut;
    }

    public List<Haircut> getMensHaircuts() {
        if (mensHaircuts == null) {
            mensHaircuts = haircutService.findMenAll();
        }
        return mensHaircuts;
    }

    public List<Haircut> getWomensHaircuts() {
        if (womensHaircuts == null) {
            womensHaircuts = haircutService.findWomenAll();
        }
        return womensHaircuts;
    }

    public HaircutsManager() {
    }
    
    public String chooseCurrent(Haircut haircut) {
        currentHaircut = haircut;
        return "haircut";
    }
}