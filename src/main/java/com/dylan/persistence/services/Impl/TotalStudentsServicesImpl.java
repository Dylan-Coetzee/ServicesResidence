/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dylan.persistence.services.Impl;

import com.dylan.persistence.domain.BusWaitingStation;
import com.dylan.persistence.domain.Student;
import com.dylan.persistence.repository.BusWaitingStationRepository;
import com.dylan.persistence.services.TotalStudentsServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dylan
 */
@Service
public class TotalStudentsServicesImpl implements TotalStudentsServices {
    @Autowired
     private BusWaitingStationRepository BusWaitingStationRepository;

    @Override
    public List<BusWaitingStation> getTotalPeople() {
        return BusWaitingStationRepository.findAll();
    }
}
