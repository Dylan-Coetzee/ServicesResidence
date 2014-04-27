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
public class MediaCentre implements Serializable  {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int numberOfPcs;
    private int numberOfKeyboards;

    public MediaCentre() {
    }

    private MediaCentre(Builder builder){
        id = builder.id;
        numberOfPcs = builder.numberOfPcs;
        numberOfKeyboards = builder.numberOfKeyboards;
    }

    public void setNumberOfPcs(int numberOfPcs) {
        this.numberOfPcs = numberOfPcs;
    }

    public void setNumberOfKeyboards(int numberOfKeyboards) {
        this.numberOfKeyboards = numberOfKeyboards;
    }
    
    public static class Builder{
        private Long id;
        private int numberOfPcs;
        private int numberOfKeyboards;
      
        public Builder id(Long value){
            this.id = value;
            return this;
        }
        
        public Builder numberOfPcs(int value){
            numberOfPcs = value;
            return this;
        }
            
        public Builder numberOfKeyboards(int value){
            numberOfKeyboards = value;
            return this;
        }

        public Builder MediaCentre(MediaCentre mediaCentre){
            id = mediaCentre.getId();
            numberOfPcs = mediaCentre.getNumberOfPcs();
            numberOfKeyboards = mediaCentre.getNumberOfKeyboards(); 
            return this;
        }
        
        public MediaCentre build(){
            return new MediaCentre(this);
        }  
    }
    
    public Long getId() {
        return id;
    }

    public int getNumberOfPcs() {
        return numberOfPcs;
    }

    public int getNumberOfKeyboards() {
        return numberOfKeyboards;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final MediaCentre other = (MediaCentre) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MediaCentre{" + "id=" + id + '}';
    }
}
