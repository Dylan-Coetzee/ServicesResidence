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
public class Room implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int roomSize;
    private String roomColour;
    private String matColour;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id")
    List<Student> students;

    public Room() {
    }
    
    private Room(Builder builder){
        id = builder.id;
        students = builder.students;
        roomSize = builder.roomSize;
        roomColour = builder.roomColour; 
        matColour = builder.matColour;
    }

    public void setRoomSize(int roomSize) {
        this.roomSize = roomSize;
    }

    public void setRoomColour(String roomColour) {
        this.roomColour = roomColour;
    }

    public void setMatColour(String matColour) {
        this.matColour = matColour;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    
    public static class Builder{
        private Long id;
        private int roomSize;
        private String roomColour;
        private String matColour;
        List<Student> students;
        
        public Builder id(Long value){
            this.id = value;
            return this;
        }
        
        public Builder students(List<Student> value){
            this.students = value;
            return this;
        }
        
        public Builder roomSize(int value){
            roomSize = value;
            return this;
        }
        
        public Builder roomColour(String value){
            roomColour = value;
            return this;
        }
        
        public Builder matColour(String value){
            matColour = value;
            return this;
        }
        
        public Builder Room(Room room){
            id = room.getId();
            roomSize = room.getRoomSize();
            roomColour = room.getRoomColour();
            matColour = room.getMatColour();
            students = room.getStudents();
            return this;
        }
        
        public Room build(){
            return new Room(this);
        }
    }

    public Long getId() {
        return id;
    }

    public int getRoomSize() {
        return roomSize;
    }

    public String getRoomColour() {
        return roomColour;
    }

    public String getMatColour() {
        return matColour;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Room other = (Room) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Room{" + "id=" + id + '}';
    }
}
