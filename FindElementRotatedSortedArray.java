class FindElementRotatedSortedArray {

    /*  Executed on leetcode
    
    *   Time Complexity: O(logn)
    *   Space Complexity:O(1)
    * 
    * */


    public int search(int[] nums, int target) {

        if(nums.length == 1)
            return nums[0] == target ? 0 : -1;
        int minElementIndex = -1;

        if(nums[0] < nums[nums.length -1])
            minElementIndex = 0;
        else
            minElementIndex = binarySearch(nums, 0, nums.length-1);

        if(nums[minElementIndex] == target)
            return minElementIndex;

        if( minElementIndex == 0)
            return normalBinarySearch(nums, target, 0, nums.length-1);

        if(target < nums[0])
            return normalBinarySearch(nums, target, minElementIndex, nums.length-1);
        else
            return normalBinarySearch(nums, target, 0, minElementIndex);

    }

    public int binarySearch(int[] nums, int low, int high){

        if(high >= low){
            int mid = (high +low)/2;
            if(nums[mid] > nums[mid +1])
                return mid+1;
            else {
                if(nums[mid] < nums[low])
                    return binarySearch(nums, low, mid -1);
                else
                    return binarySearch(nums, mid+1, high);
            }
        }
        return 0;
    }

    public int normalBinarySearch(int[] nums, int target, int low, int high){
        if(high >= low){
            int mid =  (high +low)/2;
            if(nums[mid] == target)
                return mid;
            else if(target > nums[mid])
                return normalBinarySearch(nums, target, mid+1, high);
            else
                return normalBinarySearch(nums, target, low, mid-1);
        }
        return -1;
    }
}