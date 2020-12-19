// Time Complexity : O(sqrt(n)) n is number of elements in array, sqrt(n) : to find r length 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No premium account
// Any problem you faced while coding this : No 



class InBinSearch { 
    static int binarySearch(int arr[], int l, int r, int x) 
    { 
        while (l <= r) { // regular binary search
            int mid = l + (r-l)/2;
            if (arr[mid] == x) {
            return mid;
                
            }
            else if (arr[mid] < x) {
                l = mid+1;
            }
            else {
                r = mid-1;
            }
        } return -1; 
        
    } 
    
    public static void findPos (int arr[], int x) {
        int l=0; int r = 1;
        int val = arr[0];
        while (val < x) { // if value is smaller than x, increase the right index
           l=r; // set l = r (binary search on smaller set of elements)
           if(2*r < arr.length-1) { // double the size if 2*r is less than arr length (to avoid array bound exception)
               r = 2*r;
           }
           else {
               r = arr.length-1; // else set r equal to length of array
           }
           val = arr[r];
        } int result = binarySearch(arr,l,r,x); // call binary search
          if (result == -1) 
          System.out.println("Element not present"); 
          else
          System.out.println("Element found at index " + result); 
    }
  
    // Driver method to test above 
    public static void main(String args[]) 
    { 
        int arr[] = {2, 3, 4, 10, 40, 50, 55, 66, 77, 80, 82, 83};
        int x = 50; 
        findPos(arr, x); 
    } 
} 
