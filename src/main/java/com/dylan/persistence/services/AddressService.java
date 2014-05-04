/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dylan.persistence.services;

import com.dylan.persistence.domain.Address;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dylan
 */
@Service
public interface AddressService {
    public List<Address> getSite();
}
