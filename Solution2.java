class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        /*The idea here is to find a pivot or the reference point where we can basically split the array to search the 2
        sides*/
        while(left<right){
            int mid = left + (right-left)/2;
            if(nums[mid]>nums[right]){
                left = mid + 1;
            }
            else{
                right = mid ;
            }
        }
        int start = left;
        left = 0;
        right = nums.length-1;

        if(target>=nums[start] && target<=nums[right]){
            left = start;
        }
        else {
            right = start;
        }
        while(left<= right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if (nums[mid]>target){
                right = mid-1;

            }
            else{
                left = mid + 1;
            }
        }
        return -1;
    }

}