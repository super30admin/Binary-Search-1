// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No.

// Your code here along with comments explaining your approach in three sentences only
//Approach : As the sorted array has been rotated, one half of array will always be sorted.
// Check if target is in range of sorted half, if yes search in that part else search in other half.
class Problem2 {
    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        int left = 0;
        int right = nums.length-1;
        int res = -1;
        while(left<=right){
            int mid = left +(right - left)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] < nums[right]){
                if(target < nums[mid] || nums[right] < target){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else {
                if(target < nums[left] || target > nums[mid]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }

            }
        }



        return res;

        

    }
}
