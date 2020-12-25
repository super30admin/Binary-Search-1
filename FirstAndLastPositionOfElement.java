// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[] {-1, -1};
        }
        //Find the first occurance
        int firstOccur = binaryFirst(nums, target); 
        //Find the second occurance
        int lastOccur = binaryLast(nums, target);
        return new int[] {firstOccur, lastOccur};
    }
    private int binaryFirst(int[] nums, int target){
        //initialize low and high
        int low = 0, high = nums.length -1;
        while(low<= high){
            //compute the mid
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                //if mid is equal to the target
                if(mid == low || nums[mid] > nums[mid -1]){
                    return mid;
                }
                else{
                    //lower the high element to the left side
                    high = mid - 1;
                }
            }
            //if my target is in the right 
            else if(target > nums[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
    private int binaryLast(int[] nums, int target){
        int low = 0, high = nums.length -1;
        while(low<= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                //If my mid is same as target
                if(mid == high || nums[mid] < nums[mid + 1]){
                    return mid;
                }
                else{
                    //increment low 
                    low = mid + 1;
                }
            }
            else if(target > nums[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
}