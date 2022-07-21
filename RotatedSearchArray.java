class RotatedSearchArray {
    public int search(int[] nums, int target) {
        int firstElement = nums[0];
        int iValue = 0;
        int low;
        int high;
        int mid;
        while(firstElement > nums[iValue]){
            iValue++;
        }
        if(target < firstElement){
            low = iValue + 1;
            high = nums.length + 1;
        } else {
            low = 0;
            high = iValue -1;
        }
        
        while(low <= high){
            mid = low + (high - low) / 2;
            if(target == nums[mid]){
                return mid;
            } else if (nums[mid] < target){
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}