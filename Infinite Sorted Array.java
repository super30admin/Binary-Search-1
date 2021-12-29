// Time Complexity : O(log2(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * // This is the ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * class ArrayReader {
 *   public:
 *     int get(int index);
 * };
 */

class Solution {
public:
    int search(const ArrayReader& reader, int target) {
        int low = 0;                                        //Set low at index 0
        int high = 1;                                       //Set high at index 1 
        while(reader.get(high) < target){                   //Move the low and high pointers until high is less than target
            low = high;                     
            high = 2*high;                                  //Increase search space by 2x
        }

        while(low<=high){
            int mid = low + (high-low)/2;                    //To avoid integer overflow
            
            if(reader.get(mid) == target)   return mid;     //Return mid element
            else if(reader.get(mid) < target){              //Search in right half
                low = mid + 1;                
            } else{                                         //Search in left half
                high = mid - 1;
            }
        }
        return -1;                                          //Element not found 
    }
};