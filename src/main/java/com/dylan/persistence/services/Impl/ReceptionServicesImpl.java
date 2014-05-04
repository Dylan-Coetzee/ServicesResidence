/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dylan.persistence.services.Impl;

import com.dylan.persistence.domain.Reception;
import com.dylan.persistence.repository.ReceptionRepository;
import com.dylan.persistence.services.ReceptionServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dylan
 */
@Service
public class ReceptionServicesImpl implements ReceptionServices {
    @Autowired
     private ReceptionRepository receptionRepository;

    @Override
    public List<Reception> getTotalPeople() {
        return receptionRepository.findAll();
    }
}
