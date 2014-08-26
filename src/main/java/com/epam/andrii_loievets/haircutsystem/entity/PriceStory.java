/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epam.andrii_loievets.haircutsystem.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Tourist
 */
@Entity
@Table(name = "PRICESTORY")
@NamedQueries({})
public class PriceStory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator="PriceSeq")
    @SequenceGenerator(name="PriceSeq",sequenceName="PRICE_STORY_SEQ", allocationSize=1)
    @Column(name = "PRICE_ID")
    private Integer priceId;
    @NotNull
    @Column(name = "PRICE")
    private double price;
    @Column(name = "PRICE_DATE")
    @Temporal(TemporalType.DATE)
    private Date priceDate;
    @JoinColumn(name = "HAIRCUT_ID", referencedColumnName = "HAIRCUT_ID")
    @ManyToOne
    private Haircut haircut;

    public PriceStory() {
    }

    public PriceStory(Integer priceId) {
        this.priceId = priceId;
    }

    public PriceStory(Integer priceId, Integer price) {
        this.priceId = priceId;
        this.price = price;
    }

    public Integer getPriceId() {
        return priceId;
    }

    public void setPriceId(Integer priceId) {
        this.priceId = priceId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getPriceDate() {
        return priceDate;
    }

    public void setPriceDate(Date priceDate) {
        this.priceDate = priceDate;
    }

    public Haircut getHaircut() {
        return haircut;
    }

    public void setHaircut(Haircut haircut) {
        this.haircut = haircut;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (priceId != null ? priceId.hashCode() : 0);
        hash += (haircut != null ? haircut.hashCode() : 0);
        hash += (priceDate != null ? priceDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PriceStory)) {
            return false;
        }
        PriceStory other = (PriceStory) object;
        
        // date
        if ((this.priceDate == null && other.priceDate != null) ||
                (this.priceDate != null && !this.priceDate.equals(other.priceDate))) {
            return false;
        }
        
        // haircut
        if ((this.haircut == null && other.haircut != null) ||
                (this.haircut != null && !this.haircut.equals(other.haircut))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "com.epam.andrii_loievets.haircutsystem.entity.Pricestory[ haircut" +
                haircut + ", date=" + priceDate + " ]";
    }   
}