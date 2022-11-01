/*
    Time Complexity = O(logN)
    Space Complexity = O(1)
    Did this code successfully run on Leetcode : yes
 */

package com.madhurima;

public class SearchRotatedArray {

}

class Solution1 {
    public int search(int[] nums, int target) {

        if(nums == null || nums.length == 0){
            return -1;
        }

        int low = 0;
        int high = nums.length - 1;
        int mid;

        while(low <= high){
            mid = low + (high - low)/2; //to prevent integer overflow
            if(target == nums[mid]){
                return mid;
            }

            if(nums[low] <= nums[mid]){ // left side is sorted
                if(target >= nums[low] && target < nums[mid]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else{ //right side is sorted
                if(target > nums[mid] && target <= nums[high]){
                    low = mid + 1;
                }else{
                    high = mid -1;
                }

            }



        }

        return -1;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] arr = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(s.search(arr, target));
    }
}
