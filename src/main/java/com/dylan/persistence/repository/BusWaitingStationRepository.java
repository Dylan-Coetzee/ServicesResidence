/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dylan.persistence.repository;

import com.dylan.persistence.domain.BusWaitingStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.io.Serializable;

/**
 *
 * @author Dylan
 */
public interface BusWaitingStationRepository extends JpaRepository<BusWaitingStation, Long>{
    
}
