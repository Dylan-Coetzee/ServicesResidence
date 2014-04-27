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
public class Lounge implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int numberOfCouches;
    private int numberOfTables;

    public Lounge() {
    }

    private Lounge(Builder builder){
        id = builder.id;
        numberOfCouches = builder.numberOfCouches;
        numberOfTables = builder.numberOfTables;
    }

    public void setNumberOfCouches(int numberOfCouches) {
        this.numberOfCouches = numberOfCouches;
    }

    public void setNumberOfTables(int numberOfTables) {
        this.numberOfTables = numberOfTables;
    }
    
    public static class Builder{
        private Long id;
        private int numberOfCouches;
        private int numberOfTables; 
      
        public Builder id(Long value){
            this.id = value;
            return this;
        }
        
        public Builder numberOfCouches(int value){
            numberOfCouches = value;
            return this;
        }
            
        public Builder numberOfTables(int value){
            numberOfTables = value;
            return this;
        }

        public Builder Lounge(Lounge lounge){
            id = lounge.getId();
            numberOfCouches = lounge.getNumberOfCouches();
            numberOfTables = lounge.getNumberOfTables(); 
            return this;
        }
        
        public Lounge build(){
            return new Lounge(this);
        }  
    }
    
    public Long getId() {
        return id;
    }

    public int getNumberOfCouches() {
        return numberOfCouches;
    }

    public int getNumberOfTables() {
        return numberOfTables;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.id);
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
        final Lounge other = (Lounge) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Lounge{" + "id=" + id + '}';
    }
    
}
