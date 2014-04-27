/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dylan.persistence.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author dylan
 */
@Entity
public class Building implements Serializable {
    private static final long SerialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int NumberOfStories;
    private int Capacity; 

    public Building() {
    }

    private Building(Builder builder){
        id = builder.id;
        name = builder.name;
        NumberOfStories = builder.NumberOfStories;
        Capacity = builder.Capacity;  
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfStories(int NumberOfStories) {
        this.NumberOfStories = NumberOfStories;
    }

    public void setCapacity(int Capacity) {
        this.Capacity = Capacity;
    }
    
    public static class Builder{
        private Long id;
        private String name;
        private int NumberOfStories;
        private int Capacity; 
      
        public Builder id(Long value){
            this.id = value;
            return this;
        }
        
        public Builder name(String value){
            name = value;
            return this;
        }
        
        public Builder NumberOfStories(int value){
            NumberOfStories = value;
            return this;
        }
        
        public Builder Capacity(int value){
            Capacity = value;
            return this;
        }
        
        public Builder Building(Building building){
            name = building.getName();
            NumberOfStories = building.getNumberOfStories();
            Capacity = building.getCapacity(); 
            return this;
        }
        
        public Building build(){
            return new Building(this);
        }  
    }
    
    public Long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public int getNumberOfStories() {
        return NumberOfStories;
    }

    public int getCapacity() {
        return Capacity;
    }
    @Override
    public int hashCode() {
        int hash = 7;
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
        final Building other = (Building) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Building{" + "id=" + id + '}';
    }
    
}