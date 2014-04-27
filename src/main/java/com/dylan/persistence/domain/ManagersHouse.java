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
 * @author dylan
 */
@Entity
public class ManagersHouse implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_id")
    List<ResidenceManager> managers;

    public ManagersHouse() {
    }
    
    private ManagersHouse(Builder builder){
        managers = builder.managers;
    }

    public void setManagers(List<ResidenceManager> managers) {
        this.managers = managers;
    }
    
    public static class Builder{
        private Long id;
        List<ResidenceManager> managers;
      
        
        public Builder managers (List<ResidenceManager> value){
            this.managers = value;
            return this;
        }
        
        public Builder id(Long value){
            this.id = value;
            return this;
        }
        
        public Builder ManagersHouse(ManagersHouse managersHouse){
            id = managersHouse.getId();
            managers = managersHouse.getManagers();
            return this;
        }   
        
        public ManagersHouse build(){
            return new ManagersHouse(this);
        }  
    }

    public Long getId() {
        return id;
    }

    public List<ResidenceManager> getManagers() {
        return managers;
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
        final ManagersHouse other = (ManagersHouse) obj;
        if (!Objects.equals(this.managers, other.managers)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ManagersHouse{" + "id=" + id + '}';
    }

}
