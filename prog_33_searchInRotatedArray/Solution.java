package prog_33_searchInRotatedArray;

public class Solution {
    public int search(int[] nums, int target) {
        int low = 0 ;
        int high = nums.length - 1;
        while(low<=high){
            int mid = low + (high - low) / 2 ;
            if(nums[mid] == target){
                return mid ;
            }
            //Check if left side is sorted or not
            if(nums[low] <= nums[mid]){
                if(nums[low]<=target && nums[mid]>= target){
                    high = mid - 1;
                }
                else{
                    low = mid +1 ; // skip sorted part, Go to unsorted side
                }
            }
            else{ // that mean you right side is sorted
                if(nums[mid]<= target && nums[high] >= target){
                    low = mid + 1 ;
                }
                else{
                    high = mid -1 ;  // skip sorted part,  Go to unsorted side
                }
            }
        }
        return -1 ;
    }
}
