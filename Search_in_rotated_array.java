TC:O(logn)
SC:O(1)

Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array.
Memory Usage: 38.4 MB, less than 44.65% of Java online submissions for Search in Rotated Sorted Array.

Approach: We check for the sorted array in the left and right sides of mid variable.If target is within that array, we continue 
like a normal binary search.Else if target is not with in the sorted array, change the low or high pointer to check the other array.At 
any time one of the array will be sorted.

class Solution {
    public int search(int[] nums, int target) {
        
        int low=0;
        int high= nums.length-1;
        while(low <= high){
            
            int mid = low+ (high-low)/2;
            if (nums[mid]== target) return mid;
        
        else if(nums[low] <= nums[mid]){ // left is sorted
            if(nums[low] <= target && nums[mid] >= target){ // if target is in between
                high= mid-1;
            }
            else{
                low = mid+1;
            }
        }
        else {  // right is sorted
            if(nums[high]>= target && nums[mid]<= target){
                low= mid+1;
            }
            else{
                high = mid-1;
            }
        }
            
        }
         return -1  ;
        
    }
}
