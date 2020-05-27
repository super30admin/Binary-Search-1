// Time Complexity : O(log(Position))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :Yes took very long to come up with this. had to take external help


// Your code here along with comments explaining your approach

class InfiniteArray 
{ 
    // Simple binary search algorithm 
    static int binarySearch(int arr[], int left, int right, int value) 
    { 
        if (right>=left) 
        { 
            int mid = left + (right - left)/2; 
            if (arr[mid] == value) {
                return mid; 
            }
            if (arr[mid] > value) {
                return binarySearch(arr, left, mid-1, value); 
            }
            else{
            return binarySearch(arr, mid+1, right, value); 
            }
        } 
        return -1; 
    } 
   
    static int lowHighPosition(int arr[],int value)  //Used to find the left and right index of array and call Binary search
    { 
        int left = 0, right = 1; 
        int res = arr[0]; 
        while (res < value) 
        { 
            left = right;      
            if(2*right < arr.length-1) { // This will checkand make sure RIGHT does not exceed array length.
               right = 2*right;         
            }     
            else{
               right = arr.length-1; 
            }
            res = arr[right];  
        } 
        return binarySearch(arr, left, right, value); 
    } 

    //Main function below

} 