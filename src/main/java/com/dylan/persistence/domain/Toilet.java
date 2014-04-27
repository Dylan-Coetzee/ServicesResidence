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
public class Toilet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int numberOfShowers;
    private int numberOfToilets;
    private int numberOfBaths;
    private String toiletColour;

    public Toilet() {
    }
    
    private Toilet(Builder builder){
        id = builder.id;
        numberOfShowers = builder.numberOfShowers;
        numberOfToilets = builder.numberOfToilets;
        numberOfBaths = builder.numberOfBaths;  
    }

    public void setNumberOfShowers(int numberOfShowers) {
        this.numberOfShowers = numberOfShowers;
    }

    public void setNumberOfToilets(int numberOfToilets) {
        this.numberOfToilets = numberOfToilets;
    }

    public void setNumberOfBaths(int numberOfBaths) {
        this.numberOfBaths = numberOfBaths;
    }

    public void setToiletColour(String toiletColour) {
        this.toiletColour = toiletColour;
    }
    
    public static class Builder{
        private Long id;
        private int numberOfShowers;
        private int numberOfToilets;
        private int numberOfBaths;
        private String toiletColour;
      
        public Builder id(Long value){
            this.id = value;
            return this;
        }
        
        public Builder numberOfShowers(int value){
            numberOfShowers = value;
            return this;
        }
        
        public Builder numberOfToilets(int value){
            numberOfToilets = value;
            return this;
        }
        
        public Builder numberOfBaths(int value){
            numberOfBaths = value;
            return this;
        }
        
        public Builder toiletColour(String value){
            toiletColour = value;
            return this;
        }
        
        public Builder Toilet(Toilet toilet){
            id = toilet.getId();
            numberOfShowers = toilet.getNumberOfShowers();
            numberOfToilets = toilet.getNumberOfToilets(); 
            numberOfBaths = toilet.getNumberOfBaths();
            toiletColour = toilet.getToiletColour();
            return this;
        }
        
        public Toilet build(){
            return new Toilet (this);
        }
    }

    public Long getId() {
        return id;
    }

    public int getNumberOfShowers() {
        return numberOfShowers;
    }

    public int getNumberOfToilets() {
        return numberOfToilets;
    }

    public int getNumberOfBaths() {
        return numberOfBaths;
    }

    public String getToiletColour() {
        return toiletColour;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Toilet other = (Toilet) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
