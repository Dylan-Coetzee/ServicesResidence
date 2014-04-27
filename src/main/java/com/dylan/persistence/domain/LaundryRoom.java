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
public class LaundryRoom implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int numberOfMachines;
    private int numberOfDryers;
    private int numberOfToilets;

    public LaundryRoom() {
    }

    private LaundryRoom(Builder builder){
        id = builder.id;
        numberOfMachines = builder.numberOfMachines;
        numberOfDryers = builder.numberOfDryers;
        numberOfToilets = builder.numberOfToilets;
    }

    public void setNumberOfMachines(int numberOfMachines) {
        this.numberOfMachines = numberOfMachines;
    }

    public void setNumberOfDryers(int numberOfDryers) {
        this.numberOfDryers = numberOfDryers;
    }

    public void setNumberOfToilets(int numberOfToilets) {
        this.numberOfToilets = numberOfToilets;
    }
    
    public static class Builder{
        private Long id;
        private int numberOfMachines;
        private int numberOfDryers;
        private int numberOfToilets; 
      
        public Builder id(Long value){
            this.id = value;
            return this;
        }
        
        public Builder numberOfMachines(int value){
            numberOfMachines = value;
            return this;
        }
            
        public Builder numberOfDryers(int value){
            numberOfDryers = value;
            return this;
        }
        
        public Builder numberOfToilets(int value){
            numberOfToilets = value;
            return this;
        }
        
        public Builder LaundryRoom(LaundryRoom laundryRoom){
            id = laundryRoom.getId();
            numberOfMachines = laundryRoom.getNumberOfMachines();
            numberOfDryers = laundryRoom.getNumberOfDryers(); 
            numberOfToilets = laundryRoom.getNumberOfToilets();
            return this;
        }
        
        public LaundryRoom build(){
            return new LaundryRoom(this);
        }  
    }
    
    public Long getId() {
        return id;
    }

    public int getNumberOfMachines() {
        return numberOfMachines;
    }

    public int getNumberOfDryers() {
        return numberOfDryers;
    }

    public int getNumberOfToilets() {
        return numberOfToilets;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final LaundryRoom other = (LaundryRoom) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LaundryRoom{" + "id=" + id + '}';
    }
    
}
