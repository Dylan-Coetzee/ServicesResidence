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
public class Security implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;

    public Security() {
    }

    private Security(Builder builder){
        id = builder.id;
        name = builder.name;
        surname = builder.surname; 
    }
    
    public static class Builder{
        private Long id;
        private String name;
        private String surname;
      
        public Builder id(Long value){
            this.id = value;
            return this;
        }
        
        public Builder name(String value){
            name = name;
            return this;
        }
        
        public Builder surname(String value){
            surname = value;
            return this;
        }
        
        public Builder Security(Security security){
            id = security.getId();
            name = security.getName(); 
            surname = security.getSurname();
            return this;
        }
        
        public Security build(){
            return new Security (this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
   
    @Override
    public int hashCode() {
        int hash = 5;
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
        final Security other = (Security) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Security{" + "id=" + id + '}';
    }
}
