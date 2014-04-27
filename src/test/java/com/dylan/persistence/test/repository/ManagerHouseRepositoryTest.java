/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dylan.persistence.test.repository;

import com.dylan.persistence.app.conf.ConnectionConfig;
import com.dylan.persistence.domain.ManagersHouse;
import com.dylan.persistence.repository.ManagerHouseRepository;
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
public class ManagerHouseRepositoryTest {
    private static ManagerHouseRepository repo;
    private static Long id;
    private static ApplicationContext ctx;
    
    public ManagerHouseRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void createTest() {
         repo = ctx.getBean(ManagerHouseRepository.class);
         ManagersHouse h = new ManagersHouse();
         h.setManagers(null);
         repo.save(h);
         id = h.getId();
         h.toString();
         Assert.assertNotNull(id);
     }
     
     @Test
     public static void readTest(){
         repo = ctx.getBean(ManagerHouseRepository.class);
         ManagersHouse h = repo.findOne(id);         
         Assert.assertEquals(h.getId(), id);        
     }
     
     @Test(dependsOnMethods="createTest")
     public static void updateTest(){
         repo = ctx.getBean(ManagerHouseRepository.class);
         ManagersHouse a = repo.findOne(id);
         ManagersHouse update = new ManagersHouse.Builder()
                 .build();
         repo.save(update);
         Assert.assertEquals(update.getManagers(), null);
     }
     
     @Test(dependsOnMethods="readTest")
     public static void deleteTest(){
         repo = ctx.getBean(ManagerHouseRepository.class);
         repo.delete(id);
         ManagersHouse a = repo.findOne(id);
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
