/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dylan.persistence.services.Impl;

import com.dylan.persistence.domain.LaundryRoom;
import com.dylan.persistence.repository.LaundryRoomRepository;
import com.dylan.persistence.services.LaundryRoomServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dylan
 */
@Service
public class LaundryRoomServicesImpl implements LaundryRoomServices {
    @Autowired
     private LaundryRoomRepository laundryRoomRepository;

    @Override
    public List<LaundryRoom> getLaundry() {
        return laundryRoomRepository.findAll();
    }
}
