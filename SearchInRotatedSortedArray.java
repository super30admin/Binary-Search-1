// Time Complexity: O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No

class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        
        int start = 0;
        int end = nums.length - 1;
        
        while (start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == target) 
                return mid;
            if(nums[start] < target && nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] >= nums[start]) {
                if (target >= nums[start] && target < nums[mid]) 
                    end = mid - 1;
               else start = mid + 1;
          }
        else {
        if (target <= nums[end] && target > nums[mid]) 
            start = mid + 1;
        else end = mid - 1;
      }
    }
    return -1;
    }
}

