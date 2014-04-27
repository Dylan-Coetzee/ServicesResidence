/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dylan.persistence.test.repository;

import com.dylan.persistence.app.conf.ConnectionConfig;
import com.dylan.persistence.domain.Block;
import com.dylan.persistence.repository.BlockRepository;
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
public class BlockRepositoryTest {
    private static BlockRepository repo;
    private static Long id;
    private static ApplicationContext ctx;
    
    public BlockRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void createTest() {
         repo = ctx.getBean(BlockRepository.class);
         Block b = new Block();
         b.setBlockName("H-Block");
         b.setBlockType("Male");
         b.setNumberOfStories(5);
         b.setCapacity(250);
         repo.save(b);
         id = b.getId();
         b.toString();
         Assert.assertNotNull(id);
     }
     
     @Test(dependsOnMethods="createTest")
     public static void readTest(){
         repo = ctx.getBean(BlockRepository.class);
         Block b = repo.findOne(id);         
         Assert.assertEquals(b.getId(), id);
         
     }
     
     @Test(dependsOnMethods="createTest")
     public static void updateTest(){
         repo = ctx.getBean(BlockRepository.class);
         Block a = repo.findOne(id);
         Block update = new Block.Builder("X-Block")
                 .Block(a)
                 .build();
         repo.save(update);
         Assert.assertEquals(update.getCapacity(), 250);
     }
     
     @Test(dependsOnMethods="readTest")
     public static void deleteTest(){
         repo = ctx.getBean(BlockRepository.class);
         repo.delete(id);
         Block a = repo.findOne(id);
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
