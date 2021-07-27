class RotatedSortedArray{
    public int search(int[] nums, int target) {
        
        //first find the index of the minimum element        
        int minIndex = index(nums);
                 
        //if no rotation is done, we can simply call binary serch on whole range of array
        if(minIndex == 0){
            return binarySearch(nums, target, 0, nums.length-1);
        }
        
        //if target is less than nums[0], means we have to search in the increasing array after pivot element
        if(target < nums[0]){
            return binarySearch(nums, target, minIndex, nums.length-1);
        }
        else{
            //search in increasing array before the pivot element
            return binarySearch(nums, target, 0, minIndex);
        }
    }
    
    public int binarySearch(int[] nums, int target, int left, int right){
        
        while(left <= right){
             int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] < target){
                left = mid+1;
            }
            else{
                right=  mid-1;
            }
        }
        
        return -1;
    }
    public int index(int[] nums){
        
        
        if(nums.length == 1 || nums[0] < nums[nums.length-1]){
            return 0;
        }
        
        int left = 0;
        int right = nums.length-1;
        
        while(left <= right){
            
            int mid = left + (right - left)/2;
            
            if(nums[mid] > nums[mid+1]){
                return mid+1;                
            }
            if(nums[mid] < nums[mid-1]){
                return mid;
            }
            
            if(nums[mid] > nums[0]){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return -1;
    }
}