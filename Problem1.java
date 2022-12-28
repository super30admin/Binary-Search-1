public class Problem1 {

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length -1;

        // in a rotated sorted array atleast one part is always sorted, no matter where the middle is

        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target) return mid;
            else if(nums[low] <= nums[mid]){ // left sorted array
                if(nums[low] <= target && nums[mid] >= target){
                    high = mid-1;
                }
                else{
                    low = mid +1;
                }
            }
            else{// right sorted array
                if(nums[mid] <= target && nums[high] >= target){
                    low = mid +1;
                }
                else{
                    high = mid -1;
                }
            }

        }

        return -1;

    }
}
