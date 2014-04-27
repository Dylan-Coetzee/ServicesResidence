/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dylan.persistence.test.repository;

import com.dylan.persistence.app.conf.ConnectionConfig;
import com.dylan.persistence.domain.LaundryRoom;
import com.dylan.persistence.repository.LaundryRoomRepository;
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
public class LaundryRoomRepositoryTest {
    private static LaundryRoomRepository repo;
    private static Long id;
    private static ApplicationContext ctx;
    
    public LaundryRoomRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void createTest() {
         repo = ctx.getBean(LaundryRoomRepository.class);
         LaundryRoom l = new LaundryRoom();
         l.setNumberOfToilets(4);
         l.setNumberOfMachines(8);
         l.setNumberOfDryers(8);
         repo.save(l);
         id = l.getId();
         l.toString();
         Assert.assertNotNull(id);
     }
     
     @Test(dependsOnMethods="createTest")
     public static void readTest(){
         repo = ctx.getBean(LaundryRoomRepository.class);
         LaundryRoom l = repo.findOne(id);         
         Assert.assertEquals(l.getId(), id);        
     }
     
     @Test(dependsOnMethods="createTest")
     public static void updateTest(){
         repo = ctx.getBean(LaundryRoomRepository.class);
         LaundryRoom a = repo.findOne(id);
         LaundryRoom update = new LaundryRoom.Builder()
                 .LaundryRoom(a)
                 .build();
         repo.save(update);
         Assert.assertEquals(update.getNumberOfDryers(), 8);
     }
     
     @Test(dependsOnMethods="readTest")
     public static void deleteTest(){
         repo = ctx.getBean(LaundryRoomRepository.class);
         repo.delete(id);
         LaundryRoom a = repo.findOne(id);
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
