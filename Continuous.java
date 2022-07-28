// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
Instead of binary search we went with exponential search, as we are not sure with the right bound value.
Advantage of going with exponential search, we can increase the search space exponential and we can quickly
find value which left bound values.
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        int i = 1;

        while(reader.get(high) < target){
            low = low + 1;
            high = 2*low;
        }

        while(low<=high){
            int mid = low + (high-low)/2;
            if(reader.get(mid)==target){
                return mid;
            }
            else if(reader.get(mid) > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }
}