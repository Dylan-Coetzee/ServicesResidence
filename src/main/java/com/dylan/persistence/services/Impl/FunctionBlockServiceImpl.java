/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dylan.persistence.services.Impl;

import com.dylan.persistence.domain.FunctionBlock;
import com.dylan.persistence.repository.FunctionBlockRepository;
import com.dylan.persistence.services.FunctionBlockService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dylan
 */
@Service
public class FunctionBlockServiceImpl implements FunctionBlockService {
    @Autowired
     private FunctionBlockRepository functionBlockRepository;
    
    @Override
    public List<FunctionBlock> getFunctionBlock() {
        return functionBlockRepository.findAll();
    }
}
