// Time Complexity : O(log(n))
// Space Complexity :O(1);
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I struggled in identifying if the condition on line 16 should be (left <= right) OR (left < right); 


// Your code here along with comments explaining your approach
class Solution {
    public int search(int[] nums, int target) {
        //return -1, if array is null or empty
        if(nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length -1;
        
        //keep dividing and searching till left index is less than or equal to right
        while(left <= right){
            //calculate mid index
            int mid = left + (right - left)/2;
            //return mid index if target lies there
            if(nums[mid] == target) return mid;
            if(nums[left] <= nums[mid]){ //left half sorted
                if(nums[left] <= target && nums[mid] > target){
                    //target is in the left half
                    right = mid -1;
                }
                else{//target is not in the left half
                    left = mid +1;
                }
            }
            else{//right half sorted
                if(nums[mid] < target && nums[right] >= target){
                    //target is in the right half
                    left = mid +1;
                }
                else{
                    //target is not in the right half
                    right = mid -1;
                }
            }
        }
        //return -1 if target not found
        return -1;
    }
}