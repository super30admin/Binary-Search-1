// TC = O(logN)
//  SC = O(1)

class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length -1;
                
        while (low <= high){
            int mid = low + (high - low)/2;
            int comparator = nums[mid];
            if((target < nums[0]) && (nums[mid] < nums[0]) || (target >= nums[0]) && (nums[mid] >= nums[0])) {
                // both target & nums[mid] are in the same halves
                comparator = nums[mid];
            }else{
                // target & nums[mid] are in different halves
                if (target < nums[0]){
                    comparator = Integer.MIN_VALUE;
                }else{
                    comparator = Integer.MAX_VALUE;
                }
            }
            
            if(comparator == target){
                return mid;
            }else if(comparator < target){
                low = mid+1;
            }else{
                high = mid -1;
            }
            
        }
        return -1;
    }
}
