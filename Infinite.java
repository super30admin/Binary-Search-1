
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : 
// Your code here along with comments explaining your approach

static int findIndex(int arr[],int target)  
    { 
        int low = 0, high = 1; 
        int val = arr[0]; 
  
        while (arr[high] < target) 
        { 
            low = high; 
            high*=2;
        } 
  
        while (low<=high) 
        { 
            int mid = low + (high - low)/2; 
            if (arr[mid] == target) 
                return mid; 
            if (arr[mid] <= target) 
                low=mid+1;
            else
                high=mid-1;
        } 
        return -1;  
    } 