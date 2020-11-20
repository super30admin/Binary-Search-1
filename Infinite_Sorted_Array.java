// Time Complexity : O(logT), T is the index of target value
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

class Solution {
    public int search(ArrayReader reader, int target) {
        
        if (reader.get(0) == target) return 0;
        
        int low = 0, high = 1;
        
        while (reader.get(high) < target) {
            low = high;
            high *= 2;
        }
        
        int mid , num;
        
        while (low <= high) {
            mid = low + (high - low) / 2;
            num = reader.get(mid);
            if (num == target) return mid;
            else if (num > target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
        
    }
}