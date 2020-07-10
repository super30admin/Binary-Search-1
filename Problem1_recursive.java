//PROBLEM - Search in a Rotated Sorted Array 
/** 3 Pointer Approcach: 
 * Fact utilized : If we can get half items to compute at each progressive iterarion  
 * the problem can be resolved in Log N time.
 * Here we have rotated array, however at any given iteration we will always have 
 * half array sorted - either left or rigth.
 * This Symmetric Iteration is utlized tosearch item index.
 */ 
//
//time Complexity :
// Search - LOG(N)

// Space Complexity :
// O(1)

// Did this code successfully run on Leetcode : YES.
// Any problem you faced while coding this : NO

class Problem1_recursive {
    public int search(int[] nums, int target) {
        
        int start = 0;
        int end = nums.length-1;
        
        return recursive(nums, start, end, target); 
    }
    
    // [4,5,6,7,0,1,2]

    int recursive(int arr[], int start, int end, int target){

        if(start>end)
        return -1;

        int mid = start + (end-start)/2;
            
        if(arr[mid] == target)
        return mid;

        if(arr[start] <= arr[mid]){ // left sorted 
                
            if(arr[start] <= target && target < arr[mid]) end = mid - 1;
            else start = mid+1;
            
        }else{     // right sorted
            
            if(arr[mid] < target && target <= arr[end]) start = mid + 1;
            else end = mid-1;
        }

        return recursive(arr, start, end, target);
    }
}