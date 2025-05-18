/*
 * T.C: O(logn) where n:lenght of nums[].
 * S.C: O(1) no extra spaces used except the pointers.
 * 
 * Approach: As a fact i know that one part of the rotated array is always sorted 
 * so i will try to eliminate a part of the array by checking if its sorted 
 * and is the target in range. accordingly i will keep updating the pointers to 
 * shorten the array until i find my target. else return -1;
 */


class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length -1;

        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target) return mid;

            //check the left part
            if(nums[low] <= nums[mid]){
                if(target >= nums[low] && target < nums[mid]){
                    high = mid - 1;
                }else{
                    low = mid+1;
                }
            }else{
                if(target > nums[mid] && target <= nums[high]){
                    low = mid + 1;
                }else{
                    high = mid -1;
                }
            }
        }
    return -1;
    }
}