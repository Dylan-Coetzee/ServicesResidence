/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dylan.persistence.test.repository;

import com.dylan.persistence.app.conf.ConnectionConfig;
import com.dylan.persistence.domain.Toilet;
import com.dylan.persistence.repository.ToiletRepository;
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
public class ToiletRepositoryTest {
    private static ToiletRepository repo;
    private static Long id;
    private static ApplicationContext ctx;
    
    public ToiletRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void createTest() {
         repo = ctx.getBean(ToiletRepository.class);
         Toilet t = new Toilet();
         t.setNumberOfBaths(1);
         t.setNumberOfShowers(3);
         t.setNumberOfToilets(2);
         t.setToiletColour("Red");
         repo.save(t);
         id = t.getId();
         t.toString();
         Assert.assertNotNull(id);
     }
     
     @Test
     public static void readTest(){
         repo = ctx.getBean(ToiletRepository.class);
         Toilet t = repo.findOne(id);         
         Assert.assertEquals(t.getId(), id);        
     }
     
     @Test(dependsOnMethods="createTest")
     public static void updateTest(){
         repo = ctx.getBean(ToiletRepository.class);
         Toilet a = repo.findOne(id);
         Toilet update = new Toilet.Builder()
                 .build();
         repo.save(update);
         Assert.assertEquals(update.getNumberOfBaths(), 0);
     }
     
     @Test(dependsOnMethods="readTest")
     public static void deleteTest(){
         repo = ctx.getBean(ToiletRepository.class);
         repo.delete(id);
         Toilet a = repo.findOne(id);
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
