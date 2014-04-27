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
public class FunctionBlock implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int Capacity;

    public FunctionBlock() {
    }

    private FunctionBlock(Builder builder){
        id = builder.id;
        name = builder.name;
        Capacity = builder.Capacity;  
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int Capacity) {
        this.Capacity = Capacity;
    }
    
    public static class Builder{
        private Long id;
        private String name;
        private int Capacity; 
      
        public Builder id(Long value){
            this.id = value;
            return this;
        }
        
        public Builder name(String value){
            name = value;
            return this;
        }
            
        public Builder Capacity(int value){
            Capacity = value;
            return this;
        }
        
        public Builder FunctionBlock(FunctionBlock building){
            id = building.getId();
            name = building.getName();
            Capacity = building.getCapacity(); 
            return this;
        }
        
        public FunctionBlock build(){
            return new FunctionBlock(this);
        }  
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return Capacity;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final FunctionBlock other = (FunctionBlock) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FunctionBlock{" + "id=" + id + '}';
    }

}
