/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dylan.persistence.test.repository;

import com.dylan.persistence.app.conf.ConnectionConfig;
import com.dylan.persistence.domain.BusWaitingStation;
import com.dylan.persistence.repository.BusWaitingStationRepository;
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
public class BusWaitingStationRepositoryTest {
    private static BusWaitingStationRepository repo;
    private static Long id;
    private static ApplicationContext ctx;
    
    public BusWaitingStationRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void createTest() {
         repo = ctx.getBean(BusWaitingStationRepository.class);
         BusWaitingStation b = new BusWaitingStation();
         b.setCapacity(66);
         b.setStudents(null);
         repo.save(b);
         id = b.getId();
         b.toString();
         Assert.assertNotNull(id);
     }
     
     @Test(dependsOnMethods="createTest")
     public static void readTest(){
         repo = ctx.getBean(BusWaitingStationRepository.class);
         BusWaitingStation b = repo.findOne(id);         
         Assert.assertEquals(b.getId(), id);
         
     }
     
     @Test(dependsOnMethods="createTest")
     public static void updateTest(){
         repo = ctx.getBean(BusWaitingStationRepository.class);
         BusWaitingStation a = repo.findOne(id);
         BusWaitingStation update = new BusWaitingStation.Builder()
                 .BusWaitingStation(a)
                 .build();
         repo.save(update);
         Assert.assertEquals(update.getCapacity(), 66);
     }
     
     @Test(dependsOnMethods="readTest")
     public static void deleteTest(){
         repo = ctx.getBean(BusWaitingStationRepository.class);
         repo.delete(id);
         BusWaitingStation a = repo.findOne(id);
         Assert.assertNull(a);
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
