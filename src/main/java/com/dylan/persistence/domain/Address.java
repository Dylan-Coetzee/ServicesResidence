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
 * @author Dylan
 */
@Entity
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int num;
    private String name;
    
    public Address(){
        
    }
    
    private Address(Builder builder){
        id = builder.id;
        num = builder.num;
        name = builder.name;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public static class Builder{
        private Long id;
        private int num;
        private String name;
        
        public Builder(int num){
            this.num = num;
        }
        
        public Builder(String name){
            this.name = name;
        }
        
        public Builder id(Long value){
            this.id = value;
            return this;
        }
        
        public Builder Address(Address address){
            id = address.getId();
            num = address.getNum();
            name = address.getName();
            return this;
        }   
        
        public Address build(){
            return new Address(this);
        }
    }

    public Long getId() {
        return id;
    }

    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }
   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dylan.persistence.domain.address[ id=" + id + " ]";
    }
}
