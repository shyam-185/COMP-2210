import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class SelectorTest {


       //////////////////////
      // Min method cases //
     //////////////////////
    @Test
    public void testSearchTypicalMin1() {
        int[] a = {2,8,7,3,4};
        int expected = 2;
        int actual = Selector.min(a);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSearchTypicalMin2() {
        int[] a = {8,2,8,7,3,3,4};
        int expected = 2;
        int actual = Selector.min(a);
        assertEquals(expected, actual);
    }
    
    /** Test with a.length > 2, target found at front */
    @Test
    public void testSearchSpecialMin1() {
        int[] a = {2,2,2,2,2};
        int expected = 2;
        int actual = Selector.min(a);
        assertEquals(expected, actual);
    }
        
    /** Test with a.length > 2, target found at front */
    @Test
    public void testSearchSpecialMin2() {
        int[] a = {0};
        int expected = 0;
        int actual = Selector.min(a);
        assertEquals(expected, actual);
    }
    
    
       //////////////////////
      // Max method cases //
     //////////////////////
    @Test
    public void testSearchTypicalMax1() {
        int[] a = {2,8,7,3,4};
        int expected = 8;
        int actual = Selector.max(a);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSearchTypicalMax2() {
        int[] a = {8,2,8,7,3,3,4};
        int expected = 8;
        int actual = Selector.max(a);
        assertEquals(expected, actual);
    }
    
    /** Test with a.length > 2, target found at front */
    @Test
    public void testSearchSpecialMax1() {
        int[] a = {2,2,2,2,2};
        int expected = 2;
        int actual = Selector.max(a);
        assertEquals(expected, actual);
    }
        
    /** Test with a.length > 2, target found at front */
    @Test
    public void testSearchSpecialMax2() {
        int[] a = {0};
        int expected = 0;
        int actual = Selector.max(a);
        assertEquals(expected, actual);
    }
    
       ///////////////////////
      // Kmin method cases //
     ///////////////////////
    @Test
    public void testSearchTypicalKmin1() {
        int[] a = {2,8,7,3,4};
        int k = 1;
        int expected = 2;
        int actual = Selector.kmin(a,k);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSearchTypicalKmin2() {
        int[] a = {8,2,8,7,3,3,4};
        int k = 3;
        int expected = 4;
        int actual = Selector.kmin(a,k);
        assertEquals(expected, actual);
    }
    
    /** Test with a.length > 2, target found at front */
    @Test
    public void testSearchSpecialKmin1() {
        int[] a = {2,2,2,2,2};
        int k = 1;
        int expected = 2;
        int actual = Selector.kmin(a,k);
        assertEquals(expected, actual);
    }
        
    /** Test with a.length > 2, target found at front */
    @Test
    public void testSearchSpecialKmin2() {
        int[] a = {0};
        int k = 1;
        int expected = 0;
        int actual = Selector.kmin(a,k);
        assertEquals(expected, actual);
    }
    
       ///////////////////////
      // Kmax method cases //
     ///////////////////////
    @Test
    public void testSearchTypicalKmax1() {
        int[] a = {2,8,7,3,4};
        int k = 1;
        int expected = 8;
        int actual = Selector.kmax(a,k);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSearchTypicalKmax2() {
        int[] a = {8,2,8,7,3,3,4};
        int k = 3;
        int expected = 4;
        int actual = Selector.kmax(a,k);
        assertEquals(expected, actual);
    }
    
    /** Test with a.length > 2, target found at front */
    @Test
    public void testSearchSpecialKmax1() {
        int[] a = {2,2,2,2,2};
        int k = 1;
        int expected = 2;
        int actual = Selector.kmax(a,k);
        assertEquals(expected, actual);
    }
        
    /** Test with a.length > 2, target found at front */
    @Test
    public void testSearchSpecialKmax2() {
        int[] a = {0};
        int k = 1;
        int expected = 0;
        int actual = Selector.kmax(a,k);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSearchSpecialKmax3() {
        int[] a = {5,7};
        int k = 1;
        int expected = 7;
        int actual = Selector.kmax(a,k);
        assertEquals(expected, actual);
    }
    
    
       ////////////////////////
      // Range method cases //
     ////////////////////////
    @Test
    public void testSearchTypicalRange1() {
        int[] a = {2,8,7,3,4};
        int low = 1;
        int high = 5;
        int[] expected = {2,3,4};
        int[] actual = Selector.range(a,low,high);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testSearchTypicalRange2() {
        int[] a = {8,2,8,7,3,3,4};
        int low = 3;
        int high = 7;
        int[] expected = {7,3,3,4};
        int[] actual = Selector.range(a,low,high);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testSearchSpecialRange1() {
        int[] a = {2,2,2,2,2};
        int low = 2;
        int high = 4;
        int[] expected = {2,2,2,2,2};
        int[] actual = Selector.range(a,low,high);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testSearchSpecialRange2() {
        int[] a = {0};
        int low = 0;
        int high = 0;
        int[] expected = {0};
        int[] actual = Selector.range(a,low,high);
        assertArrayEquals(expected, actual);
    } 
    
    
       ////////////////////////
      // Floor method cases //
     ////////////////////////
    @Test
    public void testSearchTypicalFloor1() {
        int[] a = {2,8,7,3,4};
        int key = 6;
        int expected = 4;
        int actual = Selector.floor(a,key);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSearchTypicalFloor2() {
        int[] a = {8,2,8,7,3,3,4};
        int key = 5;
        int expected = 4;
        int actual = Selector.floor(a,key);
        assertEquals(expected, actual);
    }
    
    /** Test with a.length > 2, target found at front */
    @Test
    public void testSearchSpecialFloor1() {
        int[] a = {2,2,2,2,2};
        int key = 2;
        int expected = 2;
        int actual = Selector.floor(a,key);
        assertEquals(expected, actual);
    }
        
    /** Test with a.length > 2, target found at front */
    @Test
    public void testSearchSpecialFloor2() {
        int[] a = {0};
        int key = 1;
        int expected = 0;
        int actual = Selector.floor(a,key);
        assertEquals(expected, actual);
    }
    
    
       //////////////////////////
      // Ceiling method cases //
     //////////////////////////
    @Test
    public void testSearchTypicalCeiling1() {
        int[] a = {2,8,7,3,4};
        int key = 1;
        int expected = 2;
        int actual = Selector.ceiling(a,key);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSearchTypicalCeiling2() {
        int[] a = {8,2,8,7,3,3,4};
        int key = 5;
        int expected = 7;
        int actual = Selector.ceiling(a,key);
        assertEquals(expected, actual);
    }
    
    /** Test with a.length > 2, target found at front */
    @Test
    public void testSearchSpecialCeiling1() {
        int[] a = {2,2,2,2,2};
        int key = 2;
        int expected = 2;
        int actual = Selector.ceiling(a,key);
        assertEquals(expected, actual);
    }
}
