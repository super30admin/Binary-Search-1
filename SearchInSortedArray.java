class Solution {
    public int search(int[] nums, int target) {
        int l=0, h=nums.length-1;

        while(l <= h){
            int mid = (l+h)>>1;
            if(nums[mid] == target){
                return mid;
            }else if( nums[mid] >= nums[l] ){
                if(nums[l] <= target && nums[mid] > target){
                    h = mid-1;
                }else{
                    l = mid+1;
                }
            }else{
                if(nums[h] >= target && nums[mid] < target){
                    l = mid+1;
                }else{
                    h = mid-1 ;
                }
            }
        }
        return -1;
    }

    /**
     * Time Complexity - O(logn)
     * Space Complexity - O(1)
     */
}