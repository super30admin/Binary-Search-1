class SearchInRotatedSortedArray {
  
    /*
      Time : O(lg(N)) 
      Space : O(1)
    */
  
    /*
      Approach :
      Even if array is rotated at some pivot it will always be sorted in any one direction. 
      [6, 7, 8, 9, 10, 11, 12, 13, 14, 2, 3, 4, 5]      Target = 3
       L                    M                   H
       In above case array is sorted from Low to mid
       So first check wheater left side is completely sorted or right side is completly sorted by checking 
       nums[low] <= nums[mid] ---> if true left is sorted else right is,
       
      2. If left is sorted then, check if our target element exists in that half if so then do normal binary search there.
      3. If right is sorted then, make low = mid + 1 and continue binary search. 
    */
      
    public int search(int[] nums, int target) {
        if(nums == null) return -1;
        
        int n = nums.length;
        
        int low = 0;
        int high = n -1;
        
        while(low <= high){
            int mid = low + (high - low )/2;
            
            if(nums[mid] == target){
                    return mid;
                }else if(nums[low] <= nums[mid]){
                    if(nums[mid] > target && nums[low] <= target){
                        high = mid - 1;
                    }else{
                        low = mid + 1;
                    }
                }else{
                    if(nums[mid] < target && nums[high] >= target){
                        low = mid + 1;
                    }else{
                        high = mid - 1;
                    }
                }
            
        
        }
        
        return -1;
    }
}
