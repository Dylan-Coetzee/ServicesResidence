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
 * @author Dylan
 */
@Entity
public class Car implements Serializable{
    private static final long SerialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String parkId;

    public Car() {
    }
    
    private Car(Builder builder){
        id = builder.id;
        parkId = builder.parkId;
    }
    
    public static class Builder{
        private Long id;
        private String parkId;
        
        public Builder(String name){
            this.parkId = name;
        }
        
        public Builder id(Long value){
            this.id = value;
            return this;
        }
        
        public Builder Car(Car car){
            id = car.getId();
            parkId = car.getParkId();
            return this;
        }   
        
        public Car build(){
            return new Car(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getParkId() {
        return parkId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Car other = (Car) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Car{" + "id=" + id + '}';
    }
    
}
