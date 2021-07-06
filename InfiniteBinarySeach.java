// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : When I try to find an element which
//   is not present in the array after the 1st index, StackOverflowError is shown by the compiler.

// Your code here along with comments explaining your approach

class BinarySearch {
    //Reglur binary search
    static int binarySearch(int arr[], int l, int r, int x){
        if (r>=1){
            int mid = l + (r - l)/2;
            if(arr[mid] == x)
                return mid;
            if(arr[mid] > x)
                return binarySearch(arr, l ,mid-1, x);
            return binarySearch(arr, mid+1, r,x);
        }
        return -1;
    }
    
    //This method takes an infinite size array
    //and a key to be searched and returns its 
    //position if found else returns -1.    
    static int findPos(int arr[], int key){
        int low = 0, high = 1;
        int val = arr[0];
        
        //Finding high to do binary search
        while (val < key){
                low = high + 1; //Store previous high  
            
                high = 2*high;                 
                val = arr[high]; 
              
        }
            //Call binary search
            return binarySearch(arr, low, high, key);
    }
    
        // Driver method to test the above function 
        public static void main(String[] args)  
        { 
            int arr[] = new int[]{3, 5, 7, 9, 10, 90,  
                                100, 130, 140, 160, 170}; 
            int ans = findPos(arr,7); 

            if (ans==-1) 
                System.out.println("Element not found"); 
            else
                System.out.println("Element found at index " + ans); 
        }     
}
