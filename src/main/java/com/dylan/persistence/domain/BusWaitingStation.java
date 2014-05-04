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
public class BusWaitingStation implements Serializable{
    private static final long SerialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int Capacity;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "station_id")
    List<Student> students;

    public BusWaitingStation() {
    }

    private BusWaitingStation(Builder builder){
        id = builder.id;
        students = builder.students;
        Capacity = builder.Capacity;  
    }

    public void setCapacity(int Capacity) {
        this.Capacity = Capacity;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    
    public static class Builder{
        private Long id;
        private List<Student> students;
        private int Capacity;
      
        public Builder id(Long value){
            this.id = value;
            return this;
        }
        
        public Builder students(List<Student> value){
            students = value;
            return this;
        }
        public Builder Capacity(int value){
            Capacity = value;
            return this;
        }
        
        public Builder BusWaitingStation(BusWaitingStation buswaitingstation){
            id = buswaitingstation.getId();
            students = buswaitingstation.getStudents();
            Capacity = buswaitingstation.getCapacity(); 
            return this;
        }
        
        public BusWaitingStation build(){
            return new BusWaitingStation(this);
        }  
    }
    
    public Long getId() {
        return id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getCapacity() {
        return Capacity;
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
        if (!(object instanceof BusWaitingStation)) {
            return false;
        }
        BusWaitingStation other = (BusWaitingStation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BusWaitingStation{" + "id=" + id + '}';
    }

}
