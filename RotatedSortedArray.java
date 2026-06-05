// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 


class RotatedSortedArray {
    public int search(int[] nums, int target) {

        int left = 0, right = nums.length-1;
       
        // Use binary search to find the target in the array and check whether the left half or right half is sorted. 
        // On the basic of of the outcome, we decide which half may contain the target and discard the other half
        while(left <= right){
            
            int mid  = left + (right-left)/2;
            if(nums[mid] == target) return mid;

            else if(nums[left] <= nums[mid]){
                if(nums[left] <= target && nums[mid] > target){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            } else{
                if(nums[right] >= target && nums[mid] < target){
                  left = mid+1;
                }else{
                  right = mid-1;
                }
            }

        }

        return -1;
        
    }
}