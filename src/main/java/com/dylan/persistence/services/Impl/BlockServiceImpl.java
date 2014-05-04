/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dylan.persistence.services.Impl;

import com.dylan.persistence.domain.Block;
import com.dylan.persistence.repository.BlockRepository;
import com.dylan.persistence.services.BlockServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dylan
 */
@Service
public class BlockServiceImpl implements BlockServices{
    @Autowired
     private BlockRepository blockRepository;
    
    @Override
    public List<Block> getBlock() {
        return blockRepository.findAll();
    }
}
