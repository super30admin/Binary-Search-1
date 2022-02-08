//time complexity: O(log n)
//space complexity:O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        
        //binary search
        while (l<=r) {
            int mid = l + (r-l)/2;
            
            //if target is at mid, 
            if(target==nums[mid]) {
                return mid;
            } 
            
            //else check in right or left arrays
            //if item at mid is less than item at r, then right side is sorted
            if(nums[mid] <= nums[r]){
                //find target in right array
                //compare item at mid and r with target 
                if(nums[mid] < target && target <=nums[r]) {
                    l = mid+1;
                } else {//find target in left array
                    r = mid -1;
                }
            } else { //left side is sorted
                //compare item at l and mid with target
                if(nums[l] <= target && target<nums[mid]) {
                    r = mid-1;
                } else {
                    l = mid+1;
                }
            }
        }
        //target not found
        return -1;
    }
}