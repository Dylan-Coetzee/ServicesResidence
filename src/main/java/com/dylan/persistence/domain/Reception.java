/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dylan.persistence.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author dylan
 */
@Entity
public class Reception implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "reception_id")
    List<Security> securities;
    
    public Reception() {
    }
    
    private Reception(Builder builder){
        id = builder.id;
        securities = builder.securities;
    }

    public void setSecurities(List<Security> securities) {
        this.securities = securities;
    }
    
    public static class Builder{
        private Long id;
        List<Security> securities;
        
        public Builder id(Long value){
            this.id = value;
            return this;
        }

        public Builder securities(List<Security> value) {
            this.securities = value;
            return this;
        }
        
        public Builder Reception(Reception reception){
            id = reception.getId();
            securities = reception.getSecurities();
            return this;
        }
        
        public Reception build(){
            return new Reception(this);
        }
    } 

    public Long getId() {
        return id;
    }

    public List<Security> getSecurities() {
        return securities;
    }    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reception other = (Reception) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Reception{" + "id=" + id + '}';
    }     
}
