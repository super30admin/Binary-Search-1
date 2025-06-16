// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
  
    public  int binarySearch(int[] arr, int l, int r, int x) {
      
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);
            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }


    public  int findPos(int[] arr, int key) {
        int low =0;
        int high = 1;
        //until the element is at high is less than key
        // move low to h and double h meaning we are doubling the search space
        while(arr[high]<key){
            low = high;
            high = 2*low;
        } 

        

        // found low and high indexes where the element can present so do a binary search in this space
        return binarySearch(arr, low, high, key);
    }


}