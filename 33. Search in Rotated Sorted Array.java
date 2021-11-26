class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        int low = 0;
        int high = nums.length -1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[low] <= nums[mid]){//left is sorted
                if(nums[low]<=target && nums[mid]>target){
                    high = mid - 1;
                }else{
                    low = mid +1;
                }
            }else{ //right is sorted
                if(target > nums[mid] && target <= nums[high]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}