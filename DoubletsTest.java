import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class DoubletsTest {

   /** A test that always fails. **/
   @Test public void getHammingDistanceTest() {
      String str1 = "shyam";
      String str2 = "shaym";
      Assert.assertEquals(2,Doublets.getHammingDistance(str1, str2));
   }
   
   @Test public void getNeighborsTest() {
      String word = "shyam";
      Assert.assertEquals(2,Doublets.getHammingDistance(str1, str2));
   }
}
