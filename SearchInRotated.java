class SearchInRotated {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == -1){
            return 0;
        }
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid]>=nums[low]){ // identify if we are in sorted half
                if(target>=nums[low] && target<nums[mid]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }else{
                if(target>nums[mid] && target<=nums[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}