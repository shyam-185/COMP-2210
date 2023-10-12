import java.util.Arrays;

/**
* Defines a library of selection methods
* on arrays of ints.
*
* @author   Shyam Patel (sjp0059@auburn.edu)
* @author   Dean Hendrix (dh@auburn.edu)
* @version  09/05/2021
*
*/
public final class Selector {

    /**
     * Can't instantiate this class.
     *
     * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
     *
     */
    private Selector() { }


    /**
     * Selects the minimum value from the array a. This method
     * throws IllegalArgumentException if a is null or has zero
     * length. The array a is not changed by this method.
     */
    public static int min(int[] a) {
        if (a == null || a.length == 0) {
           throw new IllegalArgumentException();
        }
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
           if (a[i] < min) {
              min = a[i];
           }
        }
        return min;
    }


    /**
     * Selects the maximum value from the array a. This method
     * throws IllegalArgumentException if a is null or has zero
     * length. The array a is not changed by this method.
     */
    public static int max(int[] a) {
        if (a == null || a.length == 0) {
           throw new IllegalArgumentException();
        }
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
           if (a[i] > max) {
              max = a[i];
           }
        }
        return max;
    }


    /**
     * Selects the kth minimum value from the array a. This method
     * throws IllegalArgumentException if a is null, has zero length,
     * or if there is no kth minimum value. Note that there is no kth
     * minimum value if k < 1, k > a.length, or if k is larger than
     * the number of distinct values in the array. The array a is not
     * changed by this method.
     */
    public static int kmin(int[] a, int k) {
        if (a == null || a.length == 0) {
           throw new IllegalArgumentException();
        }
        if (k < 1 || k > a.length) {
           throw new IllegalArgumentException();
        }
        
        int[] copy = Arrays.copyOf(a, a.length);;
        Arrays.sort(copy);
        int placeHolder = copy[0];
        int distinctValues = 1;
        
        for (int i = 1; i < copy.length; i++) {
           if (distinctValues == k) {
              return placeHolder;
           }
           
           if (placeHolder != copy[i]) {
              distinctValues++;
              placeHolder = copy[i];
           }
        }
        if (k > distinctValues) {
           throw new IllegalArgumentException();
        }
        return placeHolder;
    }


    /**
     * Selects the kth maximum value from the array a. This method
     * throws IllegalArgumentException if a is null, has zero length,
     * or if there is no kth maximum value. Note that there is no kth
     * maximum value if k < 1, k > a.length, or if k is larger than
     * the number of distinct values in the array. The array a is not
     * changed by this method.
     */    
    public static int kmax(int[] a, int k) {
        if (a == null || a.length == 0) {
           throw new IllegalArgumentException();
        }
        if (k < 1 || k > a.length) {
           throw new IllegalArgumentException();
        }
        
        int[] test = Arrays.copyOf(a, a.length);
      Arrays.sort(test);
      
      int i = test.length - 1;
      int tracker = 1;
      while (tracker < k && i > 0) {
         if (test[i] != test[--i]) {
            tracker++;
         }
      }
      
      if (tracker != k) {
         throw new IllegalArgumentException(k + "th max does not exist.");
      }
      return test[i];
   }


    /**
     * Returns an array containing all the values in a in the
     * range [low..high]; that is, all the values that are greater
     * than or equal to low and less than or equal to high,
     * including duplicate values. The length of the returned array
     * is the same as the number of values in the range [low..high].
     * If there are no qualifying values, this method returns a
     * zero-length array. Note that low and high do not have
     * to be actual values in a. This method throws an
     * IllegalArgumentException if a is null or has zero length.
     * The array a is not changed by this method.
     */
    public static int[] range(int[] a, int low, int high) {
        if (a == null || a.length == 0) {
           throw new IllegalArgumentException();
        }
        
        int[] vals = new int[0];
        for (int i = 0; i < a.length; i++) {
           if (a[i] >= low && a[i] <= high) {
              int[] range = Arrays.copyOf(vals, vals.length + 1);
              range[vals.length] = a[i];
              vals = range;
           }
        }
        return vals;
    }


    /**
     * Returns the smallest value in a that is greater than or equal to
     * the given key. This method throws an IllegalArgumentException if
     * a is null or has zero length, or if there is no qualifying
     * value. Note that key does not have to be an actual value in a.
     * The array a is not changed by this method.
     */
    public static int ceiling(int[] a, int key) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException("Array must not be empty.");
      }
      int min = Integer.MAX_VALUE;
      for(int test : a) {
         if (test >= key && test < min) {
            min = test;
         }
      }
      if (min == Integer.MAX_VALUE) {
         throw new IllegalArgumentException("No acceptable i value");
      }
      return min;
   }


    /**
     * Returns the largest value in a that is less than or equal to
     * the given key. This method throws an IllegalArgumentException if
     * a is null or has zero length, or if there is no qualifying
     * value. Note that key does not have to be an actual value in a.
     * The array a is not changed by this method.
     */
    public static int floor(int[] a, int key) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException("Array must not be empty.");
      }
      int max = Integer.MIN_VALUE;
      for(int test : a) {
         if (test <= key && test > max) {
            max = test;
         }
      }
      if (max == Integer.MIN_VALUE) {
         throw new IllegalArgumentException("No acceptable i value");
      }
      return max;
   }

}
