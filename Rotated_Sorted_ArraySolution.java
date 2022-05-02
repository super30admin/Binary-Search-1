class Solution {
    //Time complexity is O(logn)
    //Space complexity is O(n)
    // Solution is submitted on leetcode with no errors
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while (low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target) return mid; 
            // check which side is sorted
            // less than and equal since low and mid both can same element as well
            if(nums[low]<= nums[mid]) {
                //left side sorted
                if(target< nums[mid] && target >= nums[low]){
                    //Checking if target is here or not
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            } else { 
                // right side sorted
                if (target > nums[mid] && target <=nums[high]) {
                    low = mid +1;
                } else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}