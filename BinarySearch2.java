class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int pivot;
        
        while(low<=high)
        {
            pivot = low + (high - low)/2;
            if(nums[pivot] == target)
            {
                return pivot;
            }
            else if(nums[0] <= nums[pivot])
            {
                if(target >= nums[0] && target < nums[pivot])
                {
                    high = pivot - 1;
                }
                else
                {
                    low = pivot + 1;
                }
            }
            else 
            {
                if(target <= nums[nums.length-1] && target > nums[pivot])
                {
                    low = pivot + 1;
                    
                }
                else
                {
                    high = pivot - 1;
                }
            }

        }
        
        return -1;
        
        
    }
}
