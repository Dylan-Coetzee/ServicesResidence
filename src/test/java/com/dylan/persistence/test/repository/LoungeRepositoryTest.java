/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dylan.persistence.test.repository;

import com.dylan.persistence.app.conf.ConnectionConfig;
import com.dylan.persistence.domain.Lounge;
import com.dylan.persistence.repository.LoungeRepository;
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
public class LoungeRepositoryTest {
    private static LoungeRepository repo;
    private static Long id;
    private static ApplicationContext ctx;
    
    public LoungeRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void createTest() {
         repo = ctx.getBean(LoungeRepository.class);
         Lounge l = new Lounge();
         l.setNumberOfTables(3);
         l.setNumberOfCouches(5);
         repo.save(l);
         id = l.getId();
         l.toString();
         Assert.assertNotNull(id);
     }
     
     @Test(dependsOnMethods="createTest")
     public static void readTest(){
         repo = ctx.getBean(LoungeRepository.class);
         Lounge l = repo.findOne(id);         
         Assert.assertEquals(l.getId(), id);        
     }
     
     @Test(dependsOnMethods="createTest")
     public static void updateTest(){
         repo = ctx.getBean(LoungeRepository.class);
         Lounge a = repo.findOne(id);
         Lounge update = new Lounge.Builder()
                 .Lounge(a)
                 .build();
         repo.save(update);
         Assert.assertEquals(update.getNumberOfCouches(), 5);
     }
     
     @Test(dependsOnMethods="readTest")
     public static void deleteTest(){
         repo = ctx.getBean(LoungeRepository.class);
         repo.delete(id);
         Lounge a = repo.findOne(id);
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
