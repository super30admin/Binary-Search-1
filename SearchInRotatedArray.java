// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int h = nums.length-1;
        while(l < h){
            int mid = l + (h - l)/2;
            if (nums[mid] == target) return mid;
            
            if(nums[l] <= nums[mid]){  // if the target falls into the sorted side of array
                if(nums[mid] > target && target >= nums[l]){
                    h = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
            else{ // if target is greater than mid and less than last element meaning that is there is a change of 
                //order between mid and h, hence compare the elements and reset to 
                if (target > nums[mid] && target <= nums[h]) {
                    l = mid + 1;
                } else {  // or the array has some out of order elements b/w first half
                    h = mid - 1;
                }
            }
        }
        return nums[l] == target ? l : -1;
    }
}