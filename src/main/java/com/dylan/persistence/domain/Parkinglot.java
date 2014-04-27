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
 * @author Dylan
 */
@Entity
public class Parkinglot implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "park_id")
    List<Car> cars;

    public Parkinglot() {
    }
    
    private Parkinglot(Builder builder){
        id = builder.id;
        cars = builder.cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
    
    public static class Builder{
        private Long id;
        List<Car> cars;
        
        public Builder id(Long value){
            id = value;
            return this;
        }
        
        public Builder cars(List<Car> value){
            cars = value;
            return this;
        }
        
        public Builder parkinglot(Parkinglot parkinglot){
            id = parkinglot.getId();
            cars = parkinglot.getCars();
            return this;
        }   
    
        public Parkinglot build(){
            return new Parkinglot(this);
        }
    }

    public Long getId() {
        return id;
    }

    public List<Car> getCars() {
        return cars;
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
        final Parkinglot other = (Parkinglot) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Parkinglot{" + "id=" + id + '}';
    }
    
}    
    

