class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        while(low <= high){ //low & high can be equal, this avoids another checks
            int mid = low + (high-low)/2; //avoids integer overflow
            if(nums[mid] == target) return mid;
            //left sorted array
            if(nums[low] <= nums[mid]){
                //binary search here
                if(nums[low] <= target && target < nums[mid])
                    high = mid-1 ;
                else
                    low = mid + 1;
            }
            //right sorted array
            else{
                //binary search here
                if(nums[mid] < target && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }
}