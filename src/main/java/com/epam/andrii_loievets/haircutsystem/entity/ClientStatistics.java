/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epam.andrii_loievets.haircutsystem.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Tourist
 */
@Entity
@Table(name = "CLIENTSTATISTICS")
@NamedQueries({})
public class ClientStatistics implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENT_ID")
    private Integer clientId;
    @Min(value = 0) @Max(value = 100)
    @Column(name = "DISCOUNT")
    private int discount;
    @Column(name = "TOTAL_PAID")
    private double totalPaid;
    @Min(value = 0)
    @Column(name = "TOTAL_HAIRCUTS")
    private int totalHaircuts;
    @JoinColumn(name = "CLIENT_ID", referencedColumnName = "USER_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Client client;
    @JoinColumn(name = "LAST_HAIRCUT", referencedColumnName = "HAIRCUT_ID")
    @ManyToOne
    private Haircut lastHaircut;

    public ClientStatistics() {
    }

    public ClientStatistics(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public double getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(double totalPaid) {
        this.totalPaid = totalPaid;
    }

    public int getTotalHaircuts() {
        return totalHaircuts;
    }

    public void setTotalHaircuts(int totalHaircuts) {
        this.totalHaircuts = totalHaircuts;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Haircut getLastHaircut() {
        return lastHaircut;
    }

    public void setLastHaircut(Haircut lastHaircut) {
        this.lastHaircut = lastHaircut;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (client != null ? client.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientStatistics)) {
            return false;
        }
        ClientStatistics other = (ClientStatistics) object;
        if ((this.client == null && other.client != null) || (this.client != null && !this.client.equals(other.client))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epam.andrii_loievets.haircutsystem.entity.Clientstatistics[ client=" + client + " ]";
    }
    
}
