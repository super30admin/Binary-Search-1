// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : 
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach


class Infinite_sorted_array_search{

 public int search(int arr[],int key)  
    { 
        int low = 0, high = 1; 
        int val = arr[0]; 
  
        // Find endpoint inn the infinite array to do binary search 
        while (val < key) 
        { 
            low = high;     // store previous high 
            //check that 2*h doesn't exceed array  
            if(2*high < arr.length-1) 
               high = 2*high;              
            else
               high = arr.length-1; 
              
            val = arr[high]; // update new val 
        } 
  
        // at this point we have updated low 
        // and high indices, thus use binary  
        // search between them 
        return binarySearch(arr, low, high, key); 
    } 

public int binarySearch(int arr[], int start, int end, int target) 
    { 
        if (end>=start) 
        { 
            int mid = start + (end - start)/2; 
            if (arr[mid] == target) 
                return mid; 
            if (arr[mid] > target) 
                return binarySearch(arr, start, mid-1, target); 
            return binarySearch(arr, mid+1, end, target); 
        } 
        return -1; 
    } 
}