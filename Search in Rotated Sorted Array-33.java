class Solution {
    
    // As the Question indicates that we need to complete the process in log time which implies we need to perform binary search
    // Time Complexity: O(log(n)) as its binary search
    public int search(int[] nums, int target) {
        int low = 0; // initializing low index as starting index of nums array
        int high = nums.length-1; // initializing high index as ending index of nums array
        
        while(low<=high)
        {
            int mid = low + (high-low)/2; // To prevent Integer Overflow Exception
            if(nums[mid]== target)
            {
                return mid; // This indicates target is found and we return it.
            }      

            if(nums[low]<=nums[mid]) // This indicates that the left half of array is sorted
            {
             if(target>=nums[low] && target<nums[mid]) // if this half is sorted and target lies between this range then high is changed accordingly
             {
                 high = mid-1; 
             }
             else { // If target is not between this range then we jump to the right side of array
                 low = mid+1;
             }
            }
            else { // This indicates that the right half of array is sorted
                if(target>nums[mid] && target<=nums[high])  // if this half is sorted and target lies between this range then low is changed accordingly
                {
                    low = mid+1;
                }
                else { // If target is not between this range then we jump to the left side of array
                    high = mid-1;
                }
            }
        }
        return -1; // If element is not found
}
}
