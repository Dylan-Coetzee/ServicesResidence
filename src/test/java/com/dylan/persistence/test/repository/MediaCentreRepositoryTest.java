/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dylan.persistence.test.repository;

import com.dylan.persistence.app.conf.ConnectionConfig;
import com.dylan.persistence.domain.MediaCentre;
import com.dylan.persistence.repository.MediaCentreRepository;
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
public class MediaCentreRepositoryTest {
    private static MediaCentreRepository repo;
    private static Long id;
    private static ApplicationContext ctx;
    
    public MediaCentreRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void createTest() {
         repo = ctx.getBean(MediaCentreRepository.class);
         MediaCentre m = new MediaCentre();
         m.setNumberOfPcs(25);
         m.setNumberOfKeyboards(25);
         repo.save(m);
         id = m.getId();
         m.toString();
         Assert.assertNotNull(id);
     }
     
     @Test
     public static void readTest(){
         repo = ctx.getBean(MediaCentreRepository.class);
         MediaCentre m = repo.findOne(id);         
         Assert.assertEquals(m.getId(), id);        
     }
     
     @Test(dependsOnMethods="createTest")
     public static void updateTest(){
         repo = ctx.getBean(MediaCentreRepository.class);
         MediaCentre a = repo.findOne(id);
         MediaCentre update = new MediaCentre.Builder()
                 .build();
         repo.save(update);
         Assert.assertEquals(update.getNumberOfKeyboards(), 0);
     }
     
     @Test(dependsOnMethods="readTest")
     public static void deleteTest(){
         repo = ctx.getBean(MediaCentreRepository.class);
         repo.delete(id);
         MediaCentre a = repo.findOne(id);
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
