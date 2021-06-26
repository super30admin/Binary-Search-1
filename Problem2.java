//Time Complexity: O(log N) ; Space Complexity : 0(1);
class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int low = 0;
        int high = nums.length -1;
        while (low<=high){
            int mid = low + (high - low)/2;
            if(target == nums[mid]){
                return mid;
            } // left sorted
            if(nums[low] <= nums[mid]){
                //target is in sorted array
                if(target>=nums[low] && target<nums[mid]){
                    high = mid -1;
                }else{
                    low = mid+1; //target is in unsorted array
                }
            } //right is sorted
            else{
                if(target>nums[mid] && target<=nums[high]){ //target is in sorted array
                    low = mid +1;
                } else {
                    high = mid-1; //target is in unsorted array
                }
            }
        }
        return -1;
    }
}