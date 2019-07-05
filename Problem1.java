import java.util.*;
class Solution {
    public int search(int[] nums, int target) {
       
        //Call Binary Search function and passing array, low, high and target
        return binarySearch(nums, 0, nums.length-1, target);    
    }
   
    static int binarySearch(int arr[], int l, int h, int key) 
    { 
        // if low is greater than higher we return -1
        if (l > h)  {
            return -1; 
        }
        //Calculating mid value
        int mid = l + (h-l)/2;
        
        //Return index of mid if mid is the target
        if (arr[mid] == key) {
            return mid; 
        }
        
        // if left array is sorted then we search into it.
        if (arr[l] <= arr[mid]) 
        { 
            if (key >= arr[l] && key <= arr[mid]){
               return binarySearch(arr, l, mid-1, key); 
                }
            
            return binarySearch(arr, mid+1, h, key); 
        } 
        // if right array is sorted then search into it.
        if (key >= arr[mid] && key <= arr[h]){
            return binarySearch(arr, mid+1, h, key); 
        }
        
        // Else search with l to mid -1;
        return binarySearch(arr, l, mid-1, key); 
    } 
    
}