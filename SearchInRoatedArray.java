class Solution {
    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0) return -1;
        int low=0;
        int high=nums.length-1;
        while(low<=high)
        {
            int mid=low+((high-low)/2);
            if(target==nums[mid]) return mid;
            if(nums[mid]>=nums[low]) { // left side sorted
                if(target>=nums[low] && target<=nums[mid]) // target in sorted array
                {
                    high=mid-1;
                }
                else{ // target not in sorted array
                    low=mid+1;
                }
            }
            else // right side sorted
            {
                if(target>= nums[mid] && target<= nums[high]) // target in sorted array
                {
                    low=mid+1;
                }
                else // target not in sorted array
                {
                    high=mid-1;
                }
            }
        }
        return -1;
    }
}