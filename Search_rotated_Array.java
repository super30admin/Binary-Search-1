//Time Complexity :O(log n)
//Space Complexity :O(1)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : N/A
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        // finding lowest element as pivot
        while(low<high){
            int mid = low + (high - low)/2;
            if(nums[mid] > nums[high]){
                low = mid + 1;
            }else{
                high = mid;
            }
        } 
        int pivot = low;

        // We are selecting which side to search from pivot
        if (nums[pivot] == target) return pivot;

        if (pivot == 0) {
            low = 0;
            high = nums.length - 1;
        } else if (target >= nums[0] && target <= nums[pivot - 1]) {
            low = 0;
            high = pivot - 1;
        } else {
            low = pivot;
            high = nums.length - 1;
        }
        
        // Basic Binary search Algo
        while(low <= high){
            int mid = low + (high-low)/2;
            if(target == nums[mid]) return mid;
            if(nums[mid] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
       
       return -1;  // End of Search
    }
}
