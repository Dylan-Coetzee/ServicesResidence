/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dylan.persistence.test.repository;

import com.dylan.persistence.app.conf.ConnectionConfig;
import com.dylan.persistence.domain.SecurityRoom;
import com.dylan.persistence.repository.SecurityRoomRepository;
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
public class SecurityRoomRepositoryTest {
    private static SecurityRoomRepository repo;
    private static Long id;
    private static ApplicationContext ctx;
    
    public SecurityRoomRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void createTest() {
         repo = ctx.getBean(SecurityRoomRepository.class);
         SecurityRoom r = new SecurityRoom();
         r.setSecurities(null);
         repo.save(r);
         id = r.getId();
         r.toString();
         Assert.assertNotNull(id);
     }
     
     @Test
     public static void readTest(){
         repo = ctx.getBean(SecurityRoomRepository.class);
         SecurityRoom r = repo.findOne(id);         
         Assert.assertEquals(r.getId(), id);        
     }
     
     @Test(dependsOnMethods="createTest")
     public static void updateTest(){
         repo = ctx.getBean(SecurityRoomRepository.class);
         SecurityRoom a = repo.findOne(id);
         SecurityRoom update = new SecurityRoom.Builder()
                 .Build();
         repo.save(update);
         Assert.assertEquals(update.getSecurities(), null);
     }
     
     @Test(dependsOnMethods="readTest")
     public static void deleteTest(){
         repo = ctx.getBean(SecurityRoomRepository.class);
         repo.delete(id);
         SecurityRoom a = repo.findOne(id);
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
