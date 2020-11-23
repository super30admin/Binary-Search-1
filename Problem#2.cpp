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
        
        int low = 0, high = 1;
        
        while (target > reader.get(high))
        {
            low = high;
            high = 2 * high; 
        }
        
         return binarySearch(reader, target, low, high);
        
    }
    
       int binarySearch (ArrayReader reader, int target, int low, int high){
         while(low <= high)
         {
             int mid = low + (high-low)/2;
             if(target == reader.get(mid))
             {
                 return mid;
             }
             else if(target < reader.get(mid))
             {
                 high = mid - 1;
             }
            
             else if (target > reader.get(mid))
             {
                 low = mid + 1;
             }
          }
         
         return -1;
    }
};

/*
Complexity Analysis

Time complexity : 
O(logT), where T is an index of target value.

Space complexity : 
O(1) since it's a constant space solution.
*/