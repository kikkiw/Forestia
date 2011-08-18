/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import buntsumi_agileandgit_project.Hole;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kukkik
 */
public class HoldTest{
    
    public HoldTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    Hole H = new Hole(7, 2, null);
    
    @Test
    public void getNumHoleTest() {
       assertEquals(2, H.getNumHole());
    }
    
    @Test
    public void getBeansTest() {
       assertEquals(7, H.getBeans());
    }
    
    @Test
    public void setBeansTest() {
       assertEquals(7, H.getBeans());
    }
  
}
