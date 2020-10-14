class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if(nums == null || nums.length == 0)
            return result;
        
        int low = 0, high = nums.length-1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            // Go to left if target  < middle element or mid element  == target and mid-1 element equals mid element.
			// This will give us first position of target
            if(target < nums[mid] || (mid > 0 && nums[mid] == target && nums[mid] == nums[mid-1]))
                high = mid -1;
            else if( target > nums[mid])
                low = mid + 1;
            else {
                result[0] = mid;
                break;
            }
        }
		// If first position found iterate for last position
        if(result[0] != -1) {
            int i = result[0];
            while(i < nums.length && nums[i] == target)
                i++;
            result[1] = i-1;
        }
        return result;
    }
}