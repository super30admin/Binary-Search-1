// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
1. Find the rotate index
2. Based on rotate index, perform binary search accordingly either in left half or right half of the array
 */

class Solution {
    int[] nums;
    int target;
    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        
        if(nums.length == 0)
            return -1;
        
        if(nums.length == 1)
            return nums[0] == target ? 0 : -1;
        
        int n = nums.length;
        
        int rotateIndex = getRotateIndex(0, n-1);
        
        System.out.print(rotateIndex);
        
        if(nums[rotateIndex] == target)
            return rotateIndex;
        
        if(rotateIndex == 0)
            return binarySearch(0, n - 1);
        
        if(target < nums[0] )
            return binarySearch(rotateIndex, n - 1);
        
        return binarySearch(0, rotateIndex);
        
        
    }
    
    int getRotateIndex(int left, int right) {
        if(nums[left] < nums[right])
            return 0;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            
            if(nums[mid] > nums[mid+1])
                return mid+1;
            
            if(nums[mid] < nums[left])
                right = mid - 1;
            else
                left = mid + 1;
            
        }
        
        return 0;
    }
    
    int binarySearch(int left, int right) {
        
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target)
                return mid;
            
            if(nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        
        return -1;
    }



// Time Complexity : O(log p) where p is the position of the target
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this : to identify the time complexity


// Search in a sorted Infinite array
/*
1. Find the index position of the value which is greater than the target for the first time.
2. Based on index of that value, perform binary search on that section of the array.
 */

 public int searchInfiniteArray(int[] nums, int target) {

    int low = 0, high = 1;
    int val = nums[0];

    this.nums = nums;
    this.target = target;   

    while(val < target) {
        low = high;
        high = 2*high;

        val = nums[high];
    }

    return binarySearch(low, high);

 }

}