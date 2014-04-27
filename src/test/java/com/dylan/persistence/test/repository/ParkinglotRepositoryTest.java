/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dylan.persistence.test.repository;

import com.dylan.persistence.app.conf.ConnectionConfig;
import com.dylan.persistence.domain.Parkinglot;
import com.dylan.persistence.repository.ParkinglotRepository;
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
public class ParkinglotRepositoryTest {
    private static ParkinglotRepository repo;
    private static Long id;
    private static ApplicationContext ctx;
    
    public ParkinglotRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void createTest() {
         repo = ctx.getBean(ParkinglotRepository.class);
         Parkinglot p = new Parkinglot();
         p.setCars(null);
         repo.save(p);
         id = p.getId();
         p.toString();
         Assert.assertNotNull(id);
     }
     
     @Test
     public static void readTest(){
         repo = ctx.getBean(ParkinglotRepository.class);
         Parkinglot p = repo.findOne(id);         
         Assert.assertEquals(p.getId(), id);        
     }
     
     @Test(dependsOnMethods="createTest")
     public static void updateTest(){
         repo = ctx.getBean(ParkinglotRepository.class);
         Parkinglot a = repo.findOne(id);
         Parkinglot update = new Parkinglot.Builder()
                 .build();
         repo.save(update);
         Assert.assertEquals(update.getCars(), null);
     }
     
     @Test(dependsOnMethods="readTest")
     public static void deleteTest(){
         repo = ctx.getBean(ParkinglotRepository.class);
         repo.delete(id);
         Parkinglot a = repo.findOne(id);
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
