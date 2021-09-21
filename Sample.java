/******************** Search a 2D Matrix ****************************/
// Time Complexity : O(log m + log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach

public boolean searchMatrix(int[][] matrix, int target) {
    int n = matrix.length;     // length of rows
    int m = matrix[0].length; //length of the columns
    
    int low = 0, high = m * n - 1; // initialize the pointers
    
    while(low <= high){
        int mid = low + (high - low)/2; // find the midpoint
        int i = mid / m; //row number
        int j = mid % m; // column number
        
        if(matrix[i][j] == target){ //if mid is the target element, return true as we have found the target element
            return true;
        }
        else if(matrix[i][j] > target){ // if target is smaller than mid, target lies to the left of mid. So, we move the high pointer to mid - 1. -1 beacuse we have already checked for mid 
            high = mid - 1;
        }
        else{
            low = mid + 1; // if target is greater than mid, target lies to the right of mid. So, we move the low pointer to mid + 1. +1 beacuse we have already checked for mid 
        }
    }
    return false; // if the target element is not present in the search space
}
/******************** Search in Rotated Sorted Array ****************************/
// Time Complexity : O(log n) n -> length of the array 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

if(nums == null || nums.length == 0) return -1; 
        int left = 0, right = nums.length - 1; 
        //Here we try to find the pivot - the smallest element. Once we find the pivot, we can treat it as a regular binary search problem.    
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }
            else{
                right = mid;
            }   
        }
        // The above loop breaks when left is at the lowest element
        int start = left; // This has our pivot element
        left = 0;
        right = nums.length - 1;
        
        //This check is to determine the search space that is to be used
        if(target >= nums[start] && target <= nums[right]){
            left = start;
        }
        else{
            right = start;
        }
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
    return -1;