//TC O(logn)
//SC O(1)
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int i=0;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target ){
                return mid;
            }else if(nums[low]<=nums[mid]){     // left half is sorted
                if(nums[low]<=target && nums[mid]>=target){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }else{                      // right half is sorted
                if(target>=nums[mid] && target<=nums[high]){
                     low=mid+1;
                }else{
                    high = mid-1;
                }
               
            }
        }
        return -1;
    }
}
