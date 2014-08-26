/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epam.andrii_loievets.haircutsystem.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
@Table(name = "CLIENTORDER")
@NamedQueries({})
public class ClientOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator="OrderSeq")
    @SequenceGenerator(name="OrderSeq",sequenceName="ORDER_SEQ", allocationSize=1)
    @Column(name = "ORDER_ID")
    private Integer orderId;
    @Column(name = "ORDER_DATE")
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDER_PRICE")
    private double orderPrice;
    @JoinColumn(name = "CASHIER_ID", referencedColumnName = "CASHIER_ID")
    @ManyToOne
    private Cashier cashier;
    @JoinColumn(name = "USER_ID", referencedColumnName = "CLIENT_ID")
    @ManyToOne
    private ClientStatistics clientStat;
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID")
    @ManyToOne
    private Department department;
    @JoinColumn(name = "HAIRCUT_ID", referencedColumnName = "HAIRCUT_ID")
    @ManyToOne
    private Haircut haircut;

    public ClientOrder() {
    }

    public ClientOrder(Integer orderId) {
        this.orderId = orderId;
    }

    public ClientOrder(Integer orderId, double orderPrice) {
        this.orderId = orderId;
        this.orderPrice = orderPrice;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public ClientStatistics getClientStat() {
        return clientStat;
    }

    public void setClientStat(ClientStatistics clientStat) {
        this.clientStat = clientStat;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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
        hash += (orderId != null ? orderId.hashCode() : 0);
        hash += (clientStat != null ? clientStat.hashCode() : 0);
        hash += (cashier != null ? cashier.hashCode() : 0);
        hash += (haircut != null ? haircut.hashCode() : 0);
        hash += (orderDate != null ? orderDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientOrder)) {
            return false;
        }
        ClientOrder other = (ClientOrder) object;
        
        // order id
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        
        // client
        if ((this.clientStat == null && other.clientStat != null) || (this.clientStat != null && !this.clientStat.equals(other.clientStat))) {
            return false;
        }
        
        // haircut
        if ((this.haircut == null && other.haircut != null) || (this.haircut != null && !this.haircut.equals(other.haircut))) {
            return false;
        }
        
        // cashier
        if ((this.cashier == null && other.cashier != null) || (this.cashier != null && !this.cashier.equals(other.cashier))) {
            return false;
        }
        
        // date
        if ((this.orderDate == null && other.orderDate != null) || (this.orderDate != null && !this.orderDate.equals(other.orderDate))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "com.epam.andrii_loievets.haircutsystem.entity.Clientorder[ client=" +
                clientStat + ", haircut=" + haircut + "cashier=" + cashier +
                ", date=" + orderDate + " ]";
    }
}