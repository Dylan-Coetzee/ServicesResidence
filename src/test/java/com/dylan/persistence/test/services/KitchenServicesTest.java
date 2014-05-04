/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dylan.persistence.test.services;

import com.dylan.persistence.app.conf.ConnectionConfig;
import com.dylan.persistence.domain.Kitchen;
import com.dylan.persistence.services.KitchenServices;
import static com.dylan.persistence.test.services.FunctionBlockServiceTest.ctx;
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
public class KitchenServicesTest {
    public static ApplicationContext ctx;
    private KitchenServices service;
    public KitchenServicesTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void total() {
         service = ctx.getBean(KitchenServices.class);
         List<Kitchen> kitchen = service.getKitchen();
         
         Assert.assertEquals(0, kitchen.size(), " Expect nothing at site");
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
