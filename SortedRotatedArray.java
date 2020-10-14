class SortedRotatedArray {
    public int BinarySearch(int[] nums, int first, int last, int target){ 
        if(first <= last){
            int mid = first + (last-first)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[first] <= nums[mid]){
                if(target >= nums[first] && target < nums[mid]){
                    return BinarySearch(nums, first, mid-1, target);
                }else{
                    return BinarySearch(nums, mid+1 ,last, target);
                }
           }else{
                if(target > nums[mid] && target <= nums[last]){
                    return BinarySearch(nums, mid+1, last,target);
                }else{
                    return BinarySearch(nums, first, mid-1, target);
                }
            }
        }
        return -1;  
    }
    
    public int search(int[] nums, int target) {
        return BinarySearch(nums,0,nums.length-1,target);  
    }
}