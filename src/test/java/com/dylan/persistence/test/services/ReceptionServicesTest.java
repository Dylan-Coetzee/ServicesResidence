/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dylan.persistence.test.services;

import com.dylan.persistence.app.conf.ConnectionConfig;
import com.dylan.persistence.domain.Reception;
import com.dylan.persistence.services.ReceptionServices;
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
public class ReceptionServicesTest {
    public static ApplicationContext ctx;
    private ReceptionServices service;
     
    public ReceptionServicesTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void total() {
         service = ctx.getBean(ReceptionServices.class);
         List<Reception> people = service.getTotalPeople();
         
         Assert.assertEquals(0, people.size(), " Expert no People");
     
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
