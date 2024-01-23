//  Problem2 
// Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while(low <= high){
            int mid = low + (high - low)/2;

            if(nums[mid] > nums[n -1]){
                low = mid +1;
            } else {
                high = mid -1;
            }
        }

        // binary search
        int answer = binarysearch(nums, 0,low -1,target);
        if(answer!= -1){
            return answer;
        }

        return binarysearch(nums,low,n-1,target);
    }

    private int binarysearch(int[]nums, int leftbound, int rightbound, int target)  {
        int left = leftbound, right = rightbound;
        while(left<=right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] > target){
                right = mid -1;
            } else {
                left = mid +1;
            }
        }
        return -1;

            }

}

// TC : O(logn)
//  SC: O(1)