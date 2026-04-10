// Time Complexity :OLog(M)+OLog(N)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Got confused about the out of range condition, Need to think deeper on the question 2^31-1.


// Your code here along with comments explaining your approach in three sentences only
// I made use of the solution discussed in class.
// We are not given the size of the array.
// We can start with small values low=0 and high=1.
// To keep the N value low we have many conditions, we start high by 1, we increment it by 2*x and move low as well.
//Once range it fixed we follow the same binary search approach as we do in normal sorted array. 
// We need to check the out of range condition as well, if the value is out of range we can return -1.

public class SearchUnkownSize {
/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */
interface ArrayReader {
  public default int get(int index) {
    return index;}
 }

class Solution {
    public int search(ArrayReader reader, int target) {

        int low=0,high=1;
        while(reader.get(high)<target)
        {
            low=high;
            high=2*high;
        }
        while(low<=high)
        {
            int mid=low+(high-low)/2;

            if(reader.get(mid)==target) return mid;
            if(reader.get(mid)<target)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return -1;

        
    }
}    
}

