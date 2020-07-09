
// Am using a different approach where I find the pivot element
// and then run the binary search in desired sorted array.

// Iterative Solution

// Time Complexity :O(log(n)), for finding pivot its log(n) and for finding target its log(n) i.e. 2log(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    int[] nums; // this is just a reference
    int target;
    
    private int findPivot(int low, int high){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]>nums[mid+1]) // if next element is pivot
                return mid+1;
            if(nums[mid]<nums[mid-1]) // if previous element is pivot
                return mid;
            if(nums[mid]>nums[low])
                low = mid+1;
            else
                high = mid-1;
        }
        return -1;
    }
    
    private int binarySearch(int low, int high){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]<target)
                low = mid+1;
            else
                high = mid-1;
        }
        return -1;
    }
    
    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        int start = 0;
        int end = nums.length-1;
        int pivot;
        
        if(nums.length == 0) // checking for base case
            return -1;
        if(nums[start]==target && start == end) // if there is only 1 element
            return start;
        
        if(nums[start]<=nums[end]) // if array is already sorted
            return binarySearch(start, end);
        
        pivot = findPivot(0, nums.length-1);
        
        if(nums[pivot] == target) // if pivot was the target
            return pivot;
        
        if(target >= nums[start])
            return binarySearch(start, pivot-1);
        
        else
            return binarySearch(pivot, end);
    }
}






//Recursive Solution

// Time Complexity :O(log(n)), for finding pivot its log(n) and for finding target its log(n) i.e. 2log(n)
// Space Complexity : call stack memory of every call to a function.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    int[] nums;
    int target;
    
    private int findPivot(int low, int high){
      
        int mid = low + (high-low)/2;
        if(nums[mid]>nums[mid+1]) // if next element is pivot
            return mid+1;
        if(nums[mid]<nums[mid-1]) // if previous element is pivot
            return mid;
        if(nums[mid]>nums[low])
            return findPivot(mid+1, high);
        else
            return findPivot(low, mid-1);
    }
    
    private int binarySearch(int low, int high){
        if(low>high) return -1;
        
        int mid = low + (high-low)/2;
        if(nums[mid]==target)
            return mid;
        else if(nums[mid]<target)
            return binarySearch(mid+1, high);
        else
            return binarySearch(low, mid-1);
    }
    
    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        int start = 0;
        int end = nums.length-1;
        int pivot;
        
        if(nums.length == 0) // checking for base case
            return -1;
        if(nums[start]==target && start == end) // if there is only 1 element
            return start;
        
        if(nums[start]<=nums[end]) // if array is already sorted
            return binarySearch(start, end);
        
        pivot = findPivot(0, nums.length-1);
        
        if(nums[pivot] == target) // if pivot was the target
            return pivot;
        
        if(target >= nums[start])
            return binarySearch(start, pivot-1);
        
        else
            return binarySearch(pivot, end);
    }
}