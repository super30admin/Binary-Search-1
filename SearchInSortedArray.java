package s30.week1;

public class SearchSortedArray {
    //Always atleast one half will be sorted in rotated sorted array
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high-low)/2;
            if(nums[mid] == target) return mid;
            else if(nums[low] <= nums[mid]){ //check left sorted
                if(nums[low] <= target && nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {//check right sorted
                if(nums[mid] < target && nums[high] >= target){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        // if(arr[high] == target) return high or if(arr[low] == target) return low
        return -1;
    }
}
