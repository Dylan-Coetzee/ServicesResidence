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
public class Block implements Serializable {
    private static final long SerialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String blockName;
    private String blockType;
    private int NumberOfStories;
    private int Capacity;

    public Block() {
    }

    private Block(Builder builder){
        id = builder.id;
        blockName = builder.blockName;
        blockType = builder.blockType;
        NumberOfStories = builder.NumberOfStories;
        Capacity = builder.Capacity;  
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public void setBlockType(String blockType) {
        this.blockType = blockType;
    }

    public void setNumberOfStories(int NumberOfStories) {
        this.NumberOfStories = NumberOfStories;
    }

    public void setCapacity(int Capacity) {
        this.Capacity = Capacity;
    }
    
    public static class Builder{
        private Long id;
        private String blockName;
        private String blockType;
        private int NumberOfStories;
        private int Capacity;
      
        public Builder id(Long value){
            this.id = value;
            return this;
        }
        
        public Builder(String blockName){
            this.blockName = blockName;
        }
        
        public Builder blockType(String value){
            blockType = value;
            return this;
        }
        
        public Builder NumberOfStories(int value){
            NumberOfStories = value;
            return this;
        }
        
        public Builder Capacity(int value){
            Capacity = value;
            return this;
        }
        
        public Builder Block(Block block){
            id = block.getId();
            blockName = block.getBlockName();
            blockType = block.getBlockType();
            NumberOfStories = block.getNumberOfStories();
            Capacity = block.getCapacity();
            return this;
        }   
        
        public Block build(){
            return new Block(this);
        }  
    }

    public Long getId() {
        return id;
    }
    
    public String getBlockName() {
        return blockName;
    }
    
    public String getBlockType() {
        return blockType;
    }

    public int getNumberOfStories() {
        return NumberOfStories;
    }

    public int getCapacity() {
        return Capacity;
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
        final Block other = (Block) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Block{" + "id=" + id + '}';
    }
     
}
