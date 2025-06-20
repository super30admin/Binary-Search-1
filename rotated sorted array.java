

// Time Complexity :O(log(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class Solution {
    public int search(int[] nums, int target) {
        if (nums==null || nums.length==0){ //checking base case
            return -1;
        }
        int n= nums.length;
        int low=0;
        int high= n-1;

        while(low<=high){
            int mid= low+(high-low)/2;//prevent integer overflow
            if(target== nums[mid]){
                return mid;
            }
            if(nums[low]<=nums[mid]){ // check if left side is sorted ,if it is sorted check the target lies in the range of mid and low if yes do binary search else moev to other side
                if( target >= nums[low]&& target < nums[mid]){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            } 
            else{
                if(target > nums[mid] && target <= nums[high]){
                    low=mid+1; // In the right side check target lies between mid and high if it is do binary search or else move to left
                }
                else{
                    high=mid-1;
                }
            }
             
        }
        return -1;

    }
}