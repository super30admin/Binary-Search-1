# Binary-Search-1


## Problem1 
Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)
//Time Complexity: O(n*m)
//Space Complexity: O(n*m)
//// Did this code successfully run on Leetcode : Yes
class Solution {
    private boolean binarySearch(int target, int[] arr, int low, int high)
    {
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(target == arr[mid])
                return true;
            else if ( target < arr[mid])
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int arr[] = new int[matrix.length* matrix[0].length];
        int k=0;
        for(int i=0; i< matrix.length; i++)
        {
            for(int j=0; j< matrix[0].length; j++)
            {
                arr[k++]= matrix[i][j];
            }
        }
        
        //System.out.println(Arrays.toString(arr));
        boolean answer = binarySearch(target, arr, 0, arr.length-1);
        return answer;
    }
}

## Problem2
Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)
//Time Complexity: O(N)
//Space Complexity: O(1)
//// Did this code successfully run on Leetcode :Yes

class Solution {
    
     private int binarySearch(int target, int[] arr, int low, int high)
    {
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(target == arr[mid])
                return mid;
            else if ( target < arr[mid])
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return -1;
    }
    
    public int search(int[] nums, int target) {
        int i=0;
        for(; i< nums.length-1; i++){
            if(nums[i]> nums[i+1])
                break;
            
            
        }
        int pivot = i+1;
        //System.out.println("Pivot is:" + nums[pivot]+  " at index " + pivot);
        
        int result1 = binarySearch( target,  nums,  0,  pivot-1);
        int result2 = binarySearch( target,  nums, pivot ,  nums.length-1);
        
        if(result1!= -1)
            return result1;
        else if(result2!= -1)
            return result2;
        else
            return -1;
    }
}


## Problem3
Search in Infinite sorted array: 

https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

Given a sorted array of unknown length and a number to search for, return the index of the number in the array. Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1.

//could not figure out how to detemine the value of high pointer for binary search  
