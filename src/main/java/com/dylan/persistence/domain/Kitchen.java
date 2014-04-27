/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dylan.persistence.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author dylan
 */
@Entity
public class Kitchen implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String stove;
    private String fridge;
    private String basin;

    public Kitchen() {
    }

    private Kitchen(Builder builder){
        id = builder.id;
        stove = builder.stove;
        fridge = builder.fridge;
        basin = builder.basin;  
    }

    public void setStove(String stove) {
        this.stove = stove;
    }

    public void setFridge(String fridge) {
        this.fridge = fridge;
    }

    public void setBasin(String basin) {
        this.basin = basin;
    }
    
    public static class Builder{
        private Long id;
        private String stove;
        private String fridge;
        private String basin;
      
        public Builder id(Long value){
            this.id = value;
            return this;
        }
        
        public Builder stove(String value){
            stove = value;
            return this;
        }
        
        public Builder fridge(String value){
            fridge = value;
            return this;
        }
        
        public Builder basin(String value){
            basin = value;
            return this;
        }
        
        public Builder Kitchen(Kitchen kitchen){
            id = kitchen.getId();
            stove = kitchen.getStove();
            fridge = kitchen.getFridge(); 
            basin = kitchen.getBasin();
            return this;
        }
        
        public Kitchen build(){
            return new Kitchen (this);
        }
    }
    
    public Long getId() {
        return id;
    }

    public String getStove() {
        return stove;
    }

    public String getFridge() {
        return fridge;
    }

    public String getBasin() {
        return basin;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final Kitchen other = (Kitchen) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Kitchen{" + "id=" + id + '}';
    }

}
