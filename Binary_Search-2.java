// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// As we do not have finite length of array, but the problem says O(log n) should be the time complexity of the problem, first thing that comes to my mind is binary search, second thing that came to my mind is the property of binary search, that is increase the search space by 2x or reduce the search by half. Now the only problem is the lenth of the array which is not fixed I cannot place my low and high pointer, to fix that issue we will keep on moving our low and high pointer until we find a range where our target lies.




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
        
        while(reader.get(high)<target){
            low = high;
            high =high*2;
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(reader.get(mid) == target) return mid;
            else if(reader.get(mid) > target){
                high = mid-1;
            }else{
                low=mid+1;
            }
        }
         return -1;   
    }
}