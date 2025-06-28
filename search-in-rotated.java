class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0 || nums==null){
            return -1;
        }
        int n=nums.length;
        int l=0;
        int h=nums.length-1;
        while(l<=h){
            int m=l+(h-l)/2;     //prevent int overflow
            if(nums[m]==target){
                return m;
            }
            else if(nums[l]<=nums[m]){
                if(nums[l]<=target && target<nums[m]){
                    h=m-1;
                }
                else{
                    l=m+1;
                }
            }
            else{
                if(nums[m]<target && target<=nums[h]){
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