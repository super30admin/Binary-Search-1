class Solution {
    public int search(int[] nums, int target) {
      
        // 1 2 3 4 5 6 7 8 9
        // rotated array
        // 4 5 6 7 8 9 1 2 3
        //Goal to apply BS on this rotated array
        // find the partition
        
        
        
        int start = 0;
        int end = nums.length-1;
        int mid;
        while( start <= end){
        
            mid = (start + end)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] < nums[end]){
                //right part is sorted
                // does the right sorted part contain the number?
                if(nums[mid] < target && nums[end] > target){
                    //right sorted part has the target element
                    // narrow down our search for the right half
                    start = mid + 1;
                    
                }
                else{
                    //right sorted part does not have target element
                    //narrow down search for the left half
                    end = mid - 1;
                }
            }
            else if(nums[mid] > nums[end])
            {
                //right part is not sorted 
                // that means that left part is sorted
                //doest the left sorted part contain the number?
                if(nums[start] < target && nums[mid] > target){
                    //left sorted part contains the target value
                    end = mid - 1;
                }
                else {
                    // target number belongs to the unsorted part
                    start = mid + 1;
                }
            }
        }
    
        return -1;
    }
}
