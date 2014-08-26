/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epam.andrii_loievets.haircutsystem.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Tourist
 */
@Entity
@Table(name = "HAIRCUT")
@NamedQueries({
    @NamedQuery(name = "Haircut.findByName",
            query = "SELECT h FROM Haircut h WHERE h.name = :name"),
    @NamedQuery(name = "Haircut.findAll",
            query = "SELECT h FROM Haircut h"),
    @NamedQuery(name = "Haircut.findByGender",
            query = "SELECT h FROM Haircut h WHERE h.gender = :gender")
    })
public class Haircut implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator="HaircutSeq")
    @SequenceGenerator(name="HaircutSeq",sequenceName="HAIRCUT_SEQ", allocationSize=1) 
    @Column(name = "HAIRCUT_ID")
    private Integer haircutId;
    @Enumerated(EnumType.STRING)
    @Column(name = "GENDER")
    private GenderEnum gender;
    @NotNull
    @Column(name = "PRICE")
    private double price;
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "NAME")
    private String name;
    @Basic(fetch=FetchType.LAZY)
    @Lob
    @Column(name = "DESCRIPTION")
    private String description;

    public Haircut() {
    }

    public Haircut(Integer haircutId) {
        this.haircutId = haircutId;
    }

    public Haircut(Integer haircutId, String name, double price) {
        this.haircutId = haircutId;
        this.name = name;
        this.price = price;
    }

    public Integer getHaircutId() {
        return haircutId;
    }

    public void setHaircutId(Integer haircutId) {
        this.haircutId = haircutId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        return (name != null ? name.hashCode() : 0);
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Haircut)) {
            return false;
        }
        Haircut other = (Haircut) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epam.andrii_loievets.haircutsystem.entity.Haircut[ name=" + name + " ]";
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }    
}