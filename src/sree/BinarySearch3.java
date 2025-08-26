package sree;

//Logic for searching in an infinitely sorted array has been using binary search.
//Here we increase the search space by twice. and then do binary search in the required window.
//O(log n)
class Solution {
    public int search( int arr[], int target) {
        int low = 0, high = 1;

        while(arr[high] < target){ 
            low = high ;
            high = high * 2;
        }

        while(low <= high){ 
            int mid = low + (high - low)/2;
            if(arr[mid] == target) return mid;
            if(arr[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
      
        return -1;
    }
}