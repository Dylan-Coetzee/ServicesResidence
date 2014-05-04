/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dylan.persistence.services.Impl;

import com.dylan.persistence.domain.MediaCentre;
import com.dylan.persistence.repository.MediaCentreRepository;
import com.dylan.persistence.services.MediaCentreServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dylan
 */
@Service
public class MediaCentreServicesImpl implements MediaCentreServices {
    @Autowired
     private MediaCentreRepository mediaCentreRepository;

    @Override
    public List<MediaCentre> getPeople() {
        return mediaCentreRepository.findAll();
    }
}
