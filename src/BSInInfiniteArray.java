// Time Complexity : O(logN) where N is the possible length of infinite array 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : None


/**
 * Since the array is infinite, to find the range of numbers to search
 * for the target, we have to check if the right most indexed number is
 * less than the target. Here left index is 0 and right index is 1 initially.
 * If right is less than target, make left = right and right = 2 * right until
 * target < right. Once range is found, apply binary search on this range.
 */
class Solution {
    public int search(ArrayReader reader, int target) {
        if(reader.get(0) == target) return 0;
        int left = 0, right = 1;
        while(reader.get(right) < target) {
            left = right;
            right = 2 * right;
        }

        while( left <= right) {
            int mid = left + (right - left) / 2;
            if(reader.get(mid) == target) return mid;
            else if(reader.get(mid) > target) 
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }
}