class Solution {
    public int search(int[] nums, int target) {
        //Algorithm used:
        //Compute mid index for binary search
        //1. Check target at mid idx
        //2.1 Check target on left subarray
        //2.2 Check target on right
        // for step 2- If element is not in between start-mid OR mid-end
        // means that it's on other side - so handle it by either updating
        // left index or right index around mid idx
        // & continue on binary search. Implementation below:
    	//Time Complexity: O(log N) for binary search implemented
    	//Space complexity: O(1) is constant
                               
        int l = 0;
        int r = nums.length-1;
        int mid = -1;
        while(l<=r){
            mid = (l+r)/2;
            if(nums[mid]==target) {
                return mid;
            }else if(nums[mid]>=nums[l]){
                if(target>=nums[l] && target<nums[mid]){
                    r = mid-1;
                } else{
                    l = mid+1;
                }
            }else{
                if(target>nums[mid] && target<=nums[r]){
                    l = mid+1;
                } else{
                    r = mid-1;
                }
            }
        }
        return -1;
    }
}