/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dylan.persistence.test.repository;

import com.dylan.persistence.app.conf.ConnectionConfig;
import com.dylan.persistence.domain.FunctionBlock;
import com.dylan.persistence.repository.FunctionBlockRepository;
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
public class FunctionBlockRepositoryTest {
    private static FunctionBlockRepository repo;
    private static Long id;
    private static ApplicationContext ctx;
    
    public FunctionBlockRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void createTest() {
         repo = ctx.getBean(FunctionBlockRepository.class);
         FunctionBlock f = new FunctionBlock();
         f.setName("J-FunctionBlock");
         f.setCapacity(50);
         repo.save(f);
         id = f.getId();
         f.toString();
         Assert.assertNotNull(id);
     }
     
     @Test(dependsOnMethods="createTest")
     public static void readTest(){
         repo = ctx.getBean(FunctionBlockRepository.class);
         FunctionBlock f = repo.findOne(id);         
         Assert.assertEquals(f.getId(), id);
         
     }
     
     @Test(dependsOnMethods="createTest")
     public static void updateTest(){
         repo = ctx.getBean(FunctionBlockRepository.class);
         FunctionBlock a = repo.findOne(id);
         FunctionBlock update = new FunctionBlock.Builder()
                 .FunctionBlock(a)
                 .build();
         repo.save(update);
         Assert.assertEquals(update.getCapacity(), 50);
     }
     
     @Test(dependsOnMethods="readTest")
     public static void deleteTest(){
         repo = ctx.getBean(FunctionBlockRepository.class);
         repo.delete(id);
         FunctionBlock a = repo.findOne(id);
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
