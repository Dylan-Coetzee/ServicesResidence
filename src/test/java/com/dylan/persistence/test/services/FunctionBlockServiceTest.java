/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dylan.persistence.test.services;

import com.dylan.persistence.app.conf.ConnectionConfig;
import com.dylan.persistence.domain.Building;
import com.dylan.persistence.domain.FunctionBlock;
import com.dylan.persistence.services.FunctionBlockService;
import static com.dylan.persistence.test.services.BuildingServiceTest.ctx;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Dylan
 */
public class FunctionBlockServiceTest {
    public static ApplicationContext ctx;
    private FunctionBlockService service;
    
    public FunctionBlockServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void total() {
         service = ctx.getBean(FunctionBlockService.class);
         List<FunctionBlock> function = service.getFunctionBlock();
         
         Assert.assertEquals(0, function.size(), " Expect no Functions");
     
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
