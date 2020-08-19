/*
Time Complexity : O(log n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : Yes, had trouble with the bounds of the search space

Your code here along with comments explaining your approach
1. Find the index where the array is rotated
2. Then assume that the part of the array before the rotatedIndex is appended at the end
3. To get the mid in this new array, add the rotatedIndex to the mid
4. To adjust for the extended part, do mod and circle back
*/

public class RotatedSortedArray {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        
        while (low < high) {
            mid = low + (high - low)/2;
            
            if(nums[mid] > nums[high]) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        
        int rotatedIndex = low;
        low = 0;
        high = nums.length - 1;
        int newMid = 0;
        // System.out.println("Rotated index: " + rotatedIndex);
        
        while (low <= high) {
            mid = low + (high-low)/2;
            newMid = (mid + rotatedIndex) % nums.length;
            if (nums[newMid] == target) {
                return newMid;
            }
            if (target < nums[newMid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}