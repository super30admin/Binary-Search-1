/*
Author: Akhilesh Borgaonkar
Problem: Search in Rotated Sorted Array
Approach: Using binary search to find the mid element which is larger than its neighboring elements. If a peak element is not found at
    mid then, explore towards the side of the mid which has larger element. So that as array is sorted then, you will hit the peak.
Time Complexity: O(logn) where n is number of elements in the array.
Space complexity: O(1) constant
LC Verified.
*/

class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        
        while(low <= high){
            int mid = low + (high-low)/2;
            
            if(nums[mid]==target)							//target element found at mid index
                return mid;
            
            if(nums[low]<=nums[mid]){						//check if left side of mid is sorted array and less than mid
                
                if(target<=nums[mid] && target>=nums[low])	//checking if target lies in the left sub array
                    high = mid - 1;							//if yes then we perform binary search on left sub array
                else
                    low = mid + 1;							//else we perform binary search on right sub array
            }
            
            if(nums[high]>=nums[mid]){						//check if the right side of mid is sorted and larger than mid
                
                if(target>=nums[mid] && target<=nums[high])	//checking if the target lies in the right sub array
                    low = mid + 1;							//if yes then we perform binary search on right sub array
                else
                    high = mid - 1;							//else we perform binary search on left sub array
            }
        }
        return -1;
    }
        
}