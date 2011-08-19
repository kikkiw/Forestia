/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import buntsumi_agileandgit_project.TestBuntumi;
import buntsumi_agileandgit_project.ListHole;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ei8ht
 */
public class JUnitTest {
    ListHole list = new ListHole();
    public JUnitTest() {
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
    // @Test
    // public void hello() {}
    
    @Test
    public void testCheckOpposite(){
        list.add(4,1,13);        
        list.add(4,2,12);
        list.add(4,3,11);
        list.add(4,4,10);
        list.add(4,5,9);
        list.add(4,6,8);  
        list.add(0,7,0); 
        list.add(4,8,6);
        list.add(4,9,5);
        list.add(4,10,4);
        list.add(4,11,3);
        list.add(4,12,2);
        list.add(4,13,1);
        list.add(0,14,0); 
        
        //ทดสอบว่าสองหลุมนี้ อยู่ฝ่ายเดียวกันหรือป่าว
        assertTrue(list.CheckOpposite(list.getHole(6), 1));
        
        assertFalse(list.CheckOpposite(list.getHole(6), 11));
    }
    
    @Test
    public void testStealBeans(){
        list.add(2,1,13);        
        list.add(4,2,12);
        list.add(4,3,11);
        list.add(4,4,10);
        list.add(4,5,9);
        list.add(4,6,8);  
        list.add(0,7,0); 
        list.add(4,8,6);
        list.add(4,9,5);
        list.add(4,10,4);
        list.add(4,11,3);
        list.add(4,12,2);
        list.add(3,13,1);
        list.add(0,14,0); 
        
        //ทดสอบว่าเดิการขโมยที่หลุม 6 
        //คาดว่าจะได้ค่าถั่วมา 8 เม็ด
        assertEquals(8,list.stealBeans(list.getHole(6)));
        
        assertEquals(5,list.stealBeans(list.getHole(1)));
    }
    
    @Test
    public void testShift(){
        list.add(1,1,13);        
        list.add(4,2,12);
        list.add(2,3,11);
        list.add(4,4,10);
        list.add(4,5,9);
        list.add(4,6,8);  
        list.add(0,7,0); 
        list.add(4,8,6);
        list.add(4,9,5);
        list.add(4,10,4);
        list.add(4,11,3);
        list.add(4,12,2);
        list.add(4,13,1);
        list.add(0,14,0);
        
        //การเลื่อนหลุมแบบธรรมดา
        assertEquals(list.getHole(5), list.ShiftBean(list.getHole(3), true));
        
        
    }
    
    @Test
    public void testShiftEven1(){
        list.add(8,1,13);        
        list.add(4,2,12);
        list.add(4,3,11);
        list.add(4,4,10);
        list.add(4,5,9);
        list.add(4,6,8);  
        list.add(0,7,0); 
        list.add(4,8,6);
        list.add(4,9,5);
        list.add(4,10,4);
        list.add(4,11,3);
        list.add(4,12,2);
        list.add(4,13,1);
        list.add(0,14,0);
        //การเลื่อนหลุมมีการเปลี่ยนฝั่ง
        assertEquals(list.getHole(9), list.ShiftBean(list.getHole(1), true));
    }
    
    @Test
    public void testShiftEven2(){
        list.add(1,1,13);        
        list.add(0,2,12);
        list.add(4,3,11);
        list.add(4,4,10);
        list.add(4,5,9);
        list.add(4,6,8);  
        list.add(0,7,0); 
        list.add(4,8,6);
        list.add(4,9,5);
        list.add(4,10,4);
        list.add(4,11,3);
        list.add(4,12,2);
        list.add(4,13,1);
        list.add(0,14,0);
        //การเลื่อนหลุมมีการขโมย
        assertEquals(list.getHole(12), list.ShiftBean(list.getHole(1), true));
    }
    
    
    @Test
    public void testCheckEnd(){
        TestBuntumi t = new TestBuntumi();
        assertFalse(t.checkEnd());
    }
}
