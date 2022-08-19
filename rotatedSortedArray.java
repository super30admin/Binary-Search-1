import java.util.Stack;

/*******
## Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)

Time Complexity :   O (log n) 
Space Complexity :  O (1) 
Did this code successfully run on Leetcode :    Yes (33. Search in Rotated Sorted Array)
Any problem you faced while coding this :       No
*******/

class rotatedSortedArray {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        // use binary search
        while(low <= high){
            int mid = low + (high - low) / 2;
            if (nums[mid] == target){
                return mid;
            }
            // left sorted 
            if (nums[low] <= nums[mid]){
                if(nums[low] <= target && target < nums[mid]){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            // right sorted
            else{
                if(nums[mid] < target && target <= nums[high]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        return -1;  
    } 

    public static void main(String args[]) 
    { 
        rotatedSortedArray obj = new rotatedSortedArray();
        int target = 6;
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(obj.search(nums, target));
    }
}
