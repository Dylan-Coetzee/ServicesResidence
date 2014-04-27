/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dylan.persistence.test.repository;

import com.dylan.persistence.app.conf.ConnectionConfig;
import com.dylan.persistence.domain.Building;
import com.dylan.persistence.repository.BuildingRepository;
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
public class BuildingRepositoryTest {
    private static BuildingRepository repo;
    private static Long id;
    private static ApplicationContext ctx;
    
    public BuildingRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void createTest() {
         repo = ctx.getBean(BuildingRepository.class);
         Building b = new Building();
         b.setName("Catsville");
         b.setNumberOfStories(5);
         b.setCapacity(1000);
         repo.save(b);
         id = b.getId();
         b.toString();
         Assert.assertNotNull(id);
     }
     
     @Test(dependsOnMethods="createTest")
     public static void readTest(){
         repo = ctx.getBean(BuildingRepository.class);
         Building b = repo.findOne(id);         
         Assert.assertEquals(b.getId(), id);
         
     }
     
     @Test(dependsOnMethods="createTest")
     public static void updateTest(){
         repo = ctx.getBean(BuildingRepository.class);
         Building a = repo.findOne(id);
         Building update = new Building.Builder()
                 .Building(a)
                 .build();
         repo.save(update);
         Assert.assertEquals(update.getCapacity(), 1000);
     }
     
     @Test(dependsOnMethods="readTest")
     public static void deleteTest(){
         repo = ctx.getBean(BuildingRepository.class);
         repo.delete(id);
         Building a = repo.findOne(id);
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
