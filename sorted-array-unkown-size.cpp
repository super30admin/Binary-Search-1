
// Time Complexity : O( logn ) where n is max 10000
// Space Complexity : none except the give array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : NONE


// Your code here along with comments explaining your approach
Divide in half each time taking max as 10000

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
    
    int searchrecur( int target, int left, int right, const ArrayReader& reader  ) {
        if( left > right ){
            return -1;
        }
         int mid = ( left + right )/2;
         if( reader.get(mid) == target ){
             return mid;
         }
         else if( reader.get(mid) == pow(2,31)-1 ){
              return searchrecur( target, left, mid-1, reader); 
         } else {
             if( target > reader.get(mid) ){
                 return searchrecur( target, mid+1, right, reader);
             } else {
                 return searchrecur( target, left, mid-1, reader);
             }
         }
    }
    int search(const ArrayReader& reader, int target) {
       
        int left = 0;
        int right = 10000;
        return searchrecur( target, left, right, reader );
    }
};
