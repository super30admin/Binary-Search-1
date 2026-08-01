
//binary search in rotated sorted array
// o(logn n) complexity

class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length -1;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(target == nums[mid]){ 
                return mid;
            }
            if(nums[low] <= nums[mid]){ //right sorted array 
 if(target < nums[mid] && target >= nums[low]){
                    high = mid -1;
                } else {
                    low = mid +1;
                }
                

            } else {  //left sorted array

               
if(target > nums[mid] && target <= nums[high] ){
                    low = mid+1;
                } else {
                    high = mid-1;
                }

            }
        }

        return -1;
        
    }
}