/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dylan.persistence.test.repository;

import com.dylan.persistence.app.conf.ConnectionConfig;
import com.dylan.persistence.domain.Address;
import com.dylan.persistence.repository.AddressRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Dylan
 */
public class AddressRepositoryTest {
    private static AddressRepository repo;
    private static Long id;
    private static ApplicationContext ctx;
    
    public AddressRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void createTest() {
         repo = ctx.getBean(AddressRepository.class);
         Address a = new Address();
         a.setNum(6);
         a.setName("Browning Road, Observatory, Cape Town, 7950");
         repo.save(a);
         id = a.getId();
         a.toString();
         Assert.assertNotNull(id);
     }
     
     @Test(dependsOnMethods="createTest")
     public static void readTest(){
         repo = ctx.getBean(AddressRepository.class);
         Address t = repo.findOne(id);         
         Assert.assertEquals(t.getId(), id);
         
     }
     
     @Test(dependsOnMethods="createTest")
     public static void updateTest(){
         repo = ctx.getBean(AddressRepository.class);
         Address a = repo.findOne(id);
         Address update = new Address.Builder("26 Manfred Street, Cape Town, 9800")
                 .Address(a)
                 .build();
         repo.save(update);
         Assert.assertEquals(update.getNum(), 6);
     }
     
     @Test(dependsOnMethods="readTest")
     public static void deleteTest(){
         repo = ctx.getBean(AddressRepository.class);
         repo.delete(id);
         Address a = repo.findOne(id);
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

