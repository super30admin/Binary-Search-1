//Time Complexity: O(logn)
//Space Complexity: O(1)
//Leetcode : Yes

//Binary_ search

//Sicne it is a pivoted sorted array one half is sorted and the other half is unsorted. 
//Find the mid element and compare with the target
//Update the high and low values based on the result. Once the target is found in a half, start applying binary search

class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int low = 0;
        int high = nums.length -1;
        while(low <= high) {
            int mid = low + (high - low)/2;
         
        if(nums[mid] == target){
            return mid;
        }
        if(nums[low]<=nums[mid]){
            if(nums[low]<=target && target <= nums[low]){
                high = mid-1;
            } else {
                low = mid +1;
            } else {
                if(nums[mid]<= target && target <= nums[high]){
                    low = mid +1;
                } else{
                    high = mid -1;
                }
            }
        }
return -1;
    
    }
}
//Adding the recursive function
    
class Solution1 {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        return helper(nums,target,0,nums.length-1);
        
    }

    private int helper(int[] arr, int target, int low, int high){

if(high<low)return -1;
        int mid = low + (high-low)/2;
        if(mid == target){
            return mid;
        }
        if(nums[low]<=nums[mid]){
            if(nums[low]<=target && target <= nums[low]){
                high = mid-1;
            } else {
                low = mid +1;
            } else {
                if(nums[mid]<= target && target <= nums[high]){
                    low = mid +1;
                } else{
                    high = mid -1;
                }
            }
        }
    }
}
