/*
 * Time Complexity : O(logm+logn)
 * Space Complexity :  O(1)
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this : No
 * 
 * Approach - Since we don't know the number of elements in the array, we start with low and high at index 0 & 1 respectively and we double the search space until the target lies in between 
 * low and high. There if target is not between low and high, low = high and high becomes high*2. Once we find the range of the target, we can perform binary search between the elements 
 * present in the range.  
 */

//https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/submissions/886236091/

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        while(target>reader.get(high)){
            low=high;
            high=high*2;
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(target==reader.get(mid)){
                return mid;
            }else if(target>reader.get(mid)){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
}