class Solution {
    public int search(int[] nums, int target) {
        //intialize pointers
        int l = 0;
        int r = nums.length-1;
        //apply binary search
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>=nums[l]){//means mid is part of nonrotated subarray
                //check if target is located in subarray
                if(target>=nums[l]&&target<=nums[mid]){
                    r = mid-1;
                }
                //if target is not part of subarray the array can be skipped
                else{
                    l = mid+1;
                }

            }
            else{//since mid is smaller than l rotation index is between 0 and mid
                //check if target is part of nonrotated sub array
                if(target<=nums[r]&&target>=nums[mid]){
                    l = mid+1;
                }
                else{
                    r = mid-1;
                }

            }
        }
        return -1;

    }
}