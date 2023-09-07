// ## Problem3 Search in Infinite sorted array: https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

// Time Complexity : O(log(high-low))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
// approach: we will first run a while loop to find the range of the array in which we need to search the element. For this we check if the current high gives value higher than the target. If not we change the low to the value of high, and multiply the value of high *2. Once the range is finalized we perform standard binary search







/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {

        int low =0;
        int high =1;
        int mid, temp;

        while(reader.get(high)<target)
        {
            low = high;
            high = high*2;
        }

        while(high>=low)
        {
            mid = low + (high-low)/2;
            temp =reader.get(mid);
            if(temp==target)
            {
                return mid;
            }
            else if(temp<target)
            {
                low =mid +1;
            }
            else
            {
                high = mid -1;
            }
        }
        return -1;
        
    }
}