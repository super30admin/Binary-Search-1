//Technique1 : Binary Search 
//Time Complexity : O(logn)
// Space : Complexity :  O(1)

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(nums == null || n == 0) return -1;
        int low = 0;
        int high = n-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                return mid;
            }

            else if(nums[low] <= nums[mid]){ //Check left side sorted
                if(nums[low] <= target &&  nums[mid] > target) {
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            else{ //right sorted
                if(nums[high] >= target &&  nums[mid] < target) {
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}
