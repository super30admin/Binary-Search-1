class Solution2 {
    public int search(int[] nums, int target) {
        // null check
        if(nums == null || nums.length == 0) return -1;
        // initializing low and high for the array
        int low = 0; int high = nums.length - 1;
        while(low <= high){ //Orthodox binary search
            int mid = low + (high-low)/2;
            if(nums[mid] == target){ // Target found at mid
                return mid;
            }
            else if(nums[low] <= nums[mid]){ //left sorted
                if(nums[low]<=target && nums[mid]>target){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            else{// right sorted
                if(nums[mid]<target && nums[high]>=target){
                    low = mid+1;
                }
                else high = mid+1;
            }
        }
        return -1; // Element not found in the array
    }
}