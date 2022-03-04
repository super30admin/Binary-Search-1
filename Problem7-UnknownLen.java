// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I was not able to come up with any solution 
//Note: I am implementing it after class as I was not able to come up with the solution.  
// https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/


// Your code here along with comments explaining your approach


class Solution {
    public int search(ArrayReader reader, int target) {
        if (reader.get(0) == target) return 0; //to handle empty array edge case

        //intial search boundaries
        int left = 0, right = 1;
        while (reader.get(right) <= target) { 
        // increasing search space until the right value is greater or equal to target
            left = right;
            right *= 2;
        }

        // binary search
        int mid, num;
        while (left <= right) {
            mid = left + ((right - left) / 2);
            num = reader.get(mid);

            if (num == target) return mid;
            if (num > target) right = mid - 1;
            else left = mid + 1;
        }

        // there is no target element
        return -1;
    }
}