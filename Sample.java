// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach


class Solution {
    public int search(ArrayReader reader, int target) {
        int slow = 0;
        int fast = 1;
        while (reader.get(fast) < target) {
            slow = fast;		// this acts like a sliding window where we will get a range where we can find the target
            fast *= 2;
        }
        while (slow <= fast) {
            int mid = (slow + fast)/2;
            if (reader.get(mid) == target)		//performing a binary search between indexes slow and fast
                return mid;
            else if (target < reader.get(mid))
                fast = mid - 1;
            else   slow = mid + 1;
        }
        
        return -1;
    }
}


















