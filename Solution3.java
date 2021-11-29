/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

 // Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//Increasing the high by multiples of two as binary search divides search space into 2
//once high is reached such that it is greater or equal to target
// then just carry out Bsearch
public class Solution3 {
    public int search(ArrayReader reader, int target) {
        int low=0;
        int high=1;
         while(reader.get(high)<target){
             low=high+1;
             high=2*high;
         }
        
        while(low<=high){
            int mid=low+(high-low)/2;
            if(reader.get(mid)==target)
                return mid;
            if(reader.get(mid)>target){
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return -1;
    }
}
