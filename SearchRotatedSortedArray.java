class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        //start and end required for binary tree operations
        
        while(start<=end){ //running over the array
            int mid = (start + end) / 2; //calculated the mid
            
            //case1: if found at mid position
            if(target == nums[mid]){ 
                return mid;
            }
            
            //case2 & case3 are to find which part of the array from mid is sorted
            
            //case2: checking if nums[start] is less than nums[mid]
            if(nums[start] <= nums[mid]) {
                //checking inside this now where the target could ne located
                if(target <= nums[mid] && nums[start] <= target) {
                    end = mid - 1; //because target belongs to first half
                }
                else {
                    start = mid + 1; //searching in second half
                }
            }
            
            //case3: checking if the nums[mid] is less than nums[end]
            if(nums[mid] <= nums[end]) {
                //checking again if target belongs between these values
                if(target >= nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
        }
    
        return -1;
    }
}