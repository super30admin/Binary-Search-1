class SearchInRotatedSortedArray{

//nums = [4,5,6,7,0,1,2] 
// TC : log(n)
// SC : (1)
//// Did this code successfully run on Leetcode : yes

    public int search(int[] nums, int target){
        int low = 0;
        int high = nums.length();
        while (low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target) return mid;
            else if(nums[low] <= nums[mid]) { // Chekcing if left is sorted.
                if(target > nums[low] && target < nums[mid]){
                    high = mid -1;
                }else{
                    low = mid + 1;
                }
            }else { //Right is sorted
                if(nums[mid]<target && target<nums[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}