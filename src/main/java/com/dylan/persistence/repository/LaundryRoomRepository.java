/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dylan.persistence.repository;

import com.dylan.persistence.domain.LaundryRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Dylan
 */
public interface LaundryRoomRepository extends JpaRepository<LaundryRoom, Long> {
    
}
