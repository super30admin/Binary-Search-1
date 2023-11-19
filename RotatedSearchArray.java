//TC=O(2logn)
//SC=0(1)

class Solution {
    public int search(int[] nums, int target) {
        int s=0, e=nums.length-1;
        while(s<=e){
            int m=s+(e-s)/2;
            
            if(nums[m]==target){
                return m;
            }
            
            if(nums[m]<=nums[e]){
                //right sorted
                if(nums[m]<target && target<=nums[e]){
                    //target is on right
                    s=m+1;
                }
                else{
                    e=m-1;
                }
            }
            else{
                //left sorted
                if(nums[s]<=target && target<nums[m]){
                    //target is on left
                    e=m-1;
                }
                else{
                    s=m+1;
                }
            }
        }
        return -1;
    }
}