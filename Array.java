// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class Array {
    public int search(int[] nums, int target) {
        // find pivot
        int left = 0;
        int right = nums.length -1;
        
        while(left < right){
            int midpoint = left + (right-left)/2;
            if(nums[midpoint] > nums[right]){
                left = midpoint + 1;
            }
            else
                right = midpoint;
        }
        int start = left;

        right = nums.length - 1;
        left = 0;

        if(target >= nums[start] && target<=nums[right]){
            left=start;
        }
        else
            right = start;

        while(left <= right){
            int mid = left + (right-left)/2;
            if(target == nums[mid])
                return mid;
            if(target < nums[mid]){
                right = mid -1;
            }
            else
                left = mid+1;
        }
        return -1;
    }
}