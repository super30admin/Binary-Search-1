class Solution {
    //Time complexity: O(logn)
    //Space complexity: O(1)
    public int search(int[] nums, int target) {
        int l=0,h=nums.length-1;
        while(l<=h){
            int m=l+(h-l)/2;
            if(nums[m]==target)
                return m;
            else if(nums[m]>=nums[l]){
                if(nums[l]<=target && nums[m]>target){
                    h=m-1;
                }
                else{
                    l=m+1;
                }
            }   
            else if(nums[m]<=nums[h]){
                if(nums[m]<=target && nums[h]>=target){
                    l=m+1;
                }
                else{
                    h=m-1;
                }
            }
        }
        return -1;
    }
}