class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int lowIndex = 0;
        int highIndex = nums.length - 1;
        int midIndex = 0;
        while(lowIndex <= highIndex){
            midIndex = highIndex - (highIndex - lowIndex) / 2;
            if(nums[midIndex] == target){
                return midIndex;
            }
            if(nums[lowIndex] <= nums[midIndex]){
                if(nums[lowIndex] <= target && nums[midIndex] > target){
                     highIndex = midIndex -1;
                }else{
                    lowIndex = midIndex + 1;
                }
            }else{
                if(nums[midIndex]< target && nums[highIndex] >= target){
                    lowIndex = midIndex + 1;
                }else{
                    highIndex = midIndex - 1;
                }
                    
            }
        }
        return -1;
    }
}