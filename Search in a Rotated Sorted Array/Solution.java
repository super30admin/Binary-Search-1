// O(log n) runtime complexity.
// space complexity = O(n)
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        if(nums[low]==target) return low;
        while(low<high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target) return mid;
            if(nums[low]<=nums[mid]){ //left sorted ; add '='
                if(nums[low]<=target && target<nums[mid]){ //add '='
                    high=mid; //high=mid-1;
                } else {
                    low=mid+1;
                }
            } else{
                //right sorted
                if(target>nums[mid]&&target<=nums[high]){ //add '='
                    low=mid+1;
                } else{
                    high=mid;//   high=mid-1;
                }
            }

        }
        if(nums[low]==target) return low;
        return -1;
    }
}
