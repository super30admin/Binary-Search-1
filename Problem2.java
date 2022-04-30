import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

// s30 Problem #7 - medium
// Search in Infinite sorted array: https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
/**
 * 
 */
class Problem7{
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        // find the range, low follows high and high is incremended by 2x
        while(reader.get(high) < target){
            low = high;
            high *= 2;
        }
        //perform BS to gget the index of the target
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(reader.get(mid) == target){
                return mid;
            } else if (reader.get(mid) > target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int searchEx(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        // find the range, low follows high and high is incremended by 2x
        int valueAtHigh = 0;
        while(valueAtHigh < target){
            try {
                valueAtHigh = reader.get(high);
            } catch (IndexOutOfBoundsException ex) {
                valueAtHigh = Integer.MAX_VALUE;
            } finally {
                if(valueAtHigh < target){
                    low = high;
                    high *= 2;
                }
            }
        }
        System.out.println("******target in between*****:" + low + " " + high);

        //perform BS to get the index of the target     
        while(low <= high){
            int mid = low + (high - low)/2;
            int valueAtMid = 0;
            try {
                valueAtMid = reader.get(mid);
            } catch (IndexOutOfBoundsException e) {
                valueAtMid = Integer.MAX_VALUE;
            } finally {  
                if(valueAtMid == target){
                    return mid;
                } else if (valueAtMid > target){
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}

class ArrayReader extends ArrayList<Integer>{
}

public class Problem2 {
    public static void main(String[] args) {
        // dummy values of infinity instead of exception:
        ArrayReader reader = new ArrayReader();
        Collection<Integer> c = Arrays.asList(1,2,3,4,5,6,7,8,9,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE);
        
        reader.addAll(c);
        int target = 9;
        int result = new Problem7().search(reader, target);
        System.out.println(result);

        // for real exception scenario:
        ArrayReader reader1 = new ArrayReader();
        Collection<Integer> c1 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        reader1.addAll(c1);
        int target1 = 10;
        int result1 = new Problem7().searchEx(reader1, target1);
        System.out.println(result1);

    }
}
