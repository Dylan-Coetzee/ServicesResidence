/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dylan.persistence.services.Impl;

import com.dylan.persistence.domain.Kitchen;
import com.dylan.persistence.repository.KitchenRepository;
import com.dylan.persistence.services.KitchenServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dylan
 */
@Service
public class KitchenServicesImpl implements KitchenServices {
    @Autowired
     private KitchenRepository kitchenRepository;
    
    @Override
    public List<Kitchen> getKitchen() {
        return kitchenRepository.findAll();
    }
}
