/*
Time Complexity- O(log n) since binary search is used
Space Complexity- O(n)
Problem solved after the class
 */
class Search_in_a_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {

        if(nums == null || nums.length == 0)
            return -1;
        int left = 0;
        int right = nums.length - 1;
        int mid;

        while(left <= right){
            mid = left + (right-left)/2;

            if(nums[mid] == target) return mid;

            if(nums[left] <= nums[mid]){
                if(target >= nums[left] && target < nums[mid]) right = mid-1;
                else
                    left = mid+1;
            }

            else{
                if(target > nums[mid] && target <= nums[right]) left = mid+1;
                else
                    right = mid-1;

            }
        }
        return -1;


    }
}


