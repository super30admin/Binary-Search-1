class Solution {
    public int search(int[] nums, int target) {
        
        int start = 0;
        int end = nums.length - 1;
        int mid = (start + end)/2;
        while (start<=end){
            mid = (start + end)/2;
            if (mid == target){
                return mid;
            }
            if (target > nums[start] && target >nums[end]){
                end = mid -1;
            }
            else if (target < nums[start] && target < nums[end]){
                start = mid +1;
            }
        }
        return -1;
    }
}