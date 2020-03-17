// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        
        // Case where array is empty
        if(n == 0){
            return -1;
        }   
        
        // Case where array only has one element
        if(n == 1){
            if(nums[0] == target){
                return 0;
            }
            return -1;
        }
        
        int pivotIndex = findPivotIndex(nums, 0, n-1);
        
        //If element at pivotIndex == target
        if(nums[pivotIndex] == target){
            return pivotIndex;
        }
        
        // If the array is not a rotated one, just a sorted array, then normal binary search
        if(pivotIndex == 0){
            return binSearch(nums, 0, n-1, target);
        }
        
        // Search for element in first sub-array
        if(nums[0] <= target){
            return binSearch(nums, 0, pivotIndex-1, target);
        }
        
        // Search for element in second sub-array
        return binSearch(nums, pivotIndex, n-1, target);
    }
    
    public static int findPivotIndex(int[] nums, int start, int end){
        // Case where array is a sorted array without any rotation
        if(nums[start] < nums[end]){
            return 0;
        }
        
        while(start <= end){
            int mid = (end-start)/2 + start;
            if(nums[mid] > nums[mid+1]){
                return mid+1;
            }
            else{
                if(nums[mid] < nums[start]){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
        }
        return 0;
    }
    
    public static int binSearch(int[] nums, int start, int end, int target){        
        if(start <= end){
            int mid = (end-start)/2 + start;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                return binSearch(nums, start, mid-1, target);
            }
            else{
                return binSearch(nums, mid+1, end, target);
            }
        }
        return -1;
    }
}
