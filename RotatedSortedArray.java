class RotatedSortedArray {

    // Time Complexity: O(log n)

    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return -1;
        
        int low = 0;
        int high = nums.length-1;
        int mid;
        
        while(low < high){
            mid = low + (high - low) / 2;
            if(nums[mid] > nums[high])
                low = mid + 1;
            else
                high = mid;
        }
        
        int index = low;
        
        low = 0;
        high = nums.length-1;
        
        if(target >= nums[index] && target <= nums[high])
           low = index;
        else
            high = index;
        
        while(low <= high){
            mid = low + (high - low) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        
        return -1;
    }
}