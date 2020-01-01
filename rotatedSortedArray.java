// Time Complexity : O(logn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0 || nums==null) return -1; // If array is null or empty, return -1.
        int low=0;
        int high = nums.length -1; 
        while(low<=high){
            int mid = low +(high-low)/2; // Calculate mid avoiding any overflow
            if(target == nums[mid]) return mid; // This is main returning point in the program, as the target will always be at the mid if it is present in the array.
            else if(nums[low]<=nums[mid]){ //This checks if the left side of the element is sorted.
                if(target >= nums[low] && target <= nums[mid]){ // this statement check if the target element is present between the low and the mid element
                    high = mid-1; // If the element is in middle of Low and mid, then we will change our high pointer to Mid-1
                }
                else{
                    low = mid+1; // If the element is not in middle of Low and mid, then we will change our low pointer to Mid+1;
                }
                
            }else{ //This checks if the right side of the element is sorted.
                if(target >= nums[mid] && target <= nums[high]){  // this statement check if the target element is present between the mid and the high element
                    low=mid+1; //If the element is in middle of mid and high, then we will change our low pointer to Mid+1
                }
                else{
                    high = mid-1; //If the element is not in middle of mid and high, then we will change our high pointer to Mid-1
                }
                
            }
            
        }
        return -1; // if the element is not present in the array we will return -1
    }
}