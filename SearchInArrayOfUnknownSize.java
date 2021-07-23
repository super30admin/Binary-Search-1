/*
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 *
 * 
 * // Time Complexity : O(logN)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, approach wise, but struck with taking the high as max val of Integer


// Your code here along with comments explaining your approach

 * Set low =0;
 * high = Max(Integer)
 * 
 * if it hits the upper bound, then we know we always need to search the lower half.
 * else we can increase the bound and search from mid +1 to high
 * 
 * this way we can perform binary search
 * 
 * 
 * 
 * 
 * 
 * */

class Solution {
    public int search(ArrayReader reader, int target) {
        
        int low =0;
        int high = Integer.MAX_VALUE;
        
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            
            if(reader.get(mid)==target)
            {
                return mid;
            }
            else if(reader.get(mid)==Integer.MAX_VALUE || reader.get(mid)>target)
            {
                high = mid-1;
            }
            else
            {
                low = mid +1;
            }
            
        }
        return -1;
        
    }
}