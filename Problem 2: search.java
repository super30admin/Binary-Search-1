//Binary Search : search in rotated sorted Array
Class Solution{
    public int search(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;

        while(left <= right){
            int mid = left + (right - left)/ 2;

            if(nums[mid] == target){
                   return mid;
            }
            //left half is sorted
            if(nums[left] <= nums[mid]){
                 //target lies inside the left sorted array
                 if(target >= nums[left] && target < nums[mid]){
                    right = mid -1;
                 }
                 else{
                    left = mid+1;
                 }
            }
            if(nums[left] <= nums[mid]){
                 //target lies inside the right sorted array
                 if(target > nums[mid] && target <= nums[right]){
                    left = mid +1;
                 }
                 else{
                    right = mid-1;
                 }
            }
        }
        return -1;
    }
}
