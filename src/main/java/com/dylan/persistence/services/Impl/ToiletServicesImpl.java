/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dylan.persistence.services.Impl;

import com.dylan.persistence.domain.Toilet;
import com.dylan.persistence.repository.ToiletRepository;
import com.dylan.persistence.services.ToiletServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dylan
 */
@Service
public class ToiletServicesImpl implements ToiletServices{
    @Autowired
     private ToiletRepository toiletRepository;

    @Override
    public List<Toilet> getToilets() {
        return toiletRepository.findAll();
    }
}
