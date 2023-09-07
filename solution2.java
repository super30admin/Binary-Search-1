class Solution {
    public int search(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        int mid;
        while(low<=high){
            mid=low+(high-low)/2;
            if(target==nums[mid]){
                return mid;
            }
            if(nums[low]<=nums[mid]){
                if(target>=nums[low] && target<nums[mid]){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }

            }
            else{
                if(target>nums[mid] && target<=nums[high]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }

            }

        }
        return -1;
    }
}
