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
public class ResidenceManager implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public ResidenceManager() {
    }
    
    private ResidenceManager(Builder builder){
        id = builder.id;
        name = builder.name;
    }
    
    public static class Builder{
        private Long id;
        private String name;
      
        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder name(String value){
            this.name = value;
            return this;
        }
        
        public Builder ResidenceManager(ResidenceManager residenceManager){
            id = residenceManager.getId();
            name = residenceManager.getName();
            return this;
        }
        
        public ResidenceManager build(){
            return new ResidenceManager(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final ResidenceManager other = (ResidenceManager) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ResidenceManager{" + "id=" + id + '}';
    }

}
