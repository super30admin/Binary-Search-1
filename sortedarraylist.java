class Solution {
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int mid;
        
        while (right>=left)
        {
            mid=left+(right-left)/2;
            if (nums[mid]==target)
            {
                return mid;
            }
            //left array is sorted
            if(nums[mid]>=nums[left])
            {
                if (target>=nums[left] && nums[mid]>=target)
                {
                    right=mid-1;

                }
                else
                {
                    left=mid+1;
                    
                }
            }
            //right array is sorted
            else
            {
               
                if(nums[right] >= target && nums[mid] <= target) 
                    left= mid +1;
                else
                    right=mid-1;
            }
        }
        return -1;
    }
}