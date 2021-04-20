//Time Complexity:O(logn)
//Space Complexity:O(1)
class Solution {
    public int search(int[] nums, int target) {
         
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid = left+ (right-left)/2;
            if(nums[mid]==target){
                return mid;
            }
            //left sorted
            if(nums[left]<=nums[mid]){
                if(nums[left]<=target && nums[mid]>target){
                    right=mid-1;
                }
                else{
                    left=mid+1;
                }
            }
            //right sorted
            else{
                if(nums[mid]<target && nums[right]>=target){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        return -1;
    }
}