/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dylan.persistence.services.Impl;

import com.dylan.persistence.domain.Building;
import com.dylan.persistence.repository.BuildingRepository;
import com.dylan.persistence.services.BuildingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dylan
 */
@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
     private BuildingRepository buildingRepository;
    
    @Override
    public List<Building> getBuilding() {
        return buildingRepository.findAll();
    }
}
