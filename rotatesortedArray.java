
//binary search in rotated sorted array
// o(logn n) complexity

// Time Complexity : o(logn )
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Intially I wrote a check for right sorted array which turned out to be wrong


// Your code here along with comments explaining your approach in three sentences only

// checking if mid is greater than low which ends as left sorted array , there by check elements on left if it has target in it. Else check elements in right sorted array


class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length -1;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(target == nums[mid]){ 
                return mid;
            }
            if(nums[low] <= nums[mid]){ //left sorted array 
 if(target < nums[mid] && target >= nums[low]){
                    high = mid -1;
                } else {
                    low = mid +1;
                }
                

            } else {  //right sorted array

               
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