/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dylan.persistence.services.Impl;

import com.dylan.persistence.domain.SecurityRoom;
import com.dylan.persistence.repository.SecurityRoomRepository;
import com.dylan.persistence.services.SecurityRoomServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dylan
 */
@Service
public class SecurityRoomServicesImpl implements SecurityRoomServices {
    @Autowired
     private SecurityRoomRepository securityRoomRepository;

    @Override
    public List<SecurityRoom> getSecurities() {
        return securityRoomRepository.findAll();
    }
}
