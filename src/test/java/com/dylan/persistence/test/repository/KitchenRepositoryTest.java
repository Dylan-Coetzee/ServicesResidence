/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dylan.persistence.test.repository;

import com.dylan.persistence.app.conf.ConnectionConfig;
import com.dylan.persistence.domain.Kitchen;
import com.dylan.persistence.repository.KitchenRepository;
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
public class KitchenRepositoryTest {
    private static KitchenRepository repo;
    private static Long id;
    private static ApplicationContext ctx;
    
    public KitchenRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void createTest() {
         repo = ctx.getBean(KitchenRepository.class);
         Kitchen k = new Kitchen();
         k.setStove("Defy");
         k.setFridge("LG");
         k.setBasin("Cobra Stainless Steel");
         repo.save(k);
         id = k.getId();
         k.toString();
         Assert.assertNotNull(id);
     }
     
     @Test(dependsOnMethods="createTest")
     public static void readTest(){
         repo = ctx.getBean(KitchenRepository.class);
         Kitchen k = repo.findOne(id);         
         Assert.assertEquals(k.getId(), id);        
     }
     
     @Test(dependsOnMethods="createTest")
     public static void updateTest(){
         repo = ctx.getBean(KitchenRepository.class);
         Kitchen a = repo.findOne(id);
         Kitchen update = new Kitchen.Builder()
                 .build();
         repo.save(update);
         Assert.assertEquals(update.getBasin(), null);
     }
     
     @Test(dependsOnMethods="readTest")
     public static void deleteTest(){
         repo = ctx.getBean(KitchenRepository.class);
         repo.delete(id);
         Kitchen a = repo.findOne(id);
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
