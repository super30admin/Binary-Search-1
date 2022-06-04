// Time Complexity : O(log2(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
      //Set low at index 0
        int low = 0;   
        //Set high at index 1
        int high = 1;
        //Move the low and high pointers until high is less than target
        while(reader.get(high) < target){                   
            low = high;   
            //Increase search space by 2x
            high = 2*high;                                  
        }

        while(low<=high){
            //To avoid integer overflow
            int mid = low + (high-low)/2;                    
            //Return mid element
            if(reader.get(mid) == target)   return mid;
            //Search in right half
            else if(reader.get(mid) < target){              
                low = mid + 1;                
            } 
            //Search in left half
            else{                                         
                high = mid - 1;
            }
        }
        //Element not found
        return -1;  
    }
}