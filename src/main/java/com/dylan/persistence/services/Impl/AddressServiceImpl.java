/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dylan.persistence.services.Impl;

import com.dylan.persistence.domain.Address;
import com.dylan.persistence.repository.AddressRepository;
import com.dylan.persistence.services.AddressService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dylan
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
     private AddressRepository addressRepository;
    
    @Override
    public List<Address> getSite() {
        return addressRepository.findAll();
    }
}
