/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dylan.persistence.test.services;

import com.dylan.persistence.app.conf.ConnectionConfig;
import com.dylan.persistence.domain.Toilet;
import com.dylan.persistence.services.ToiletServices;
import static com.dylan.persistence.test.services.TotalNumberBusStationTest.ctx;
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
public class ToiletServicesTest {
    public static ApplicationContext ctx;
    private ToiletServices service;
    
    public ToiletServicesTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void total() {
         service = ctx.getBean(ToiletServices.class);
         List<Toilet> toilets = service.getToilets();
         
         Assert.assertEquals(0, toilets.size(), "Expect no toilets");
     
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
