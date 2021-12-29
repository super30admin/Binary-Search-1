// Time Complexity : O(log2(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//In a rotated sorted array, it doesn't matter wherever your middle is, 
//atleast one part of the array is always going to be sorted.

class Solution {
    public int search(int[] nums, int target) {
        int low = 0; int high = nums.length -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            
            if(nums[mid] == target) return mid;
            else if(nums[low] <= nums[mid]){                         //Check if left side is sorted
                if(nums[low] <= target && nums[mid] > target){       //Check if number is present in left side
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else{                                                  //Check if right side is sorted
                if(nums[high]>=target && nums[mid] < target){       //Check if number is present in right side
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}