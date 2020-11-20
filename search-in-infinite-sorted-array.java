// Time Complexity : O(lg n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Just took time to understand the expanding boundary solution

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    
    public int search(ArrayReader reader, int target) {
        
        if(reader.get(0) == target) {
            return 0;
        }
        // start with 2 elements
        int low = 0, mid = 0, high = 1;
        
        // keep increasing the length of high as 2 * previous high to find the boundary
        while (reader.get(high) < target) {
          low = high;
          high <<= 1;
        }
        
        while(low <= high) {
            mid = low + ((high - low) >> 1);
            
            if(target == reader.get(mid)) {
                return mid;
            }
            if(target < reader.get(mid)) {
                high = mid - 1;    
            }
            else {
                low = mid + 1;
            }
        }
            
        return -1;
    }
//      Another approach, directly by taking the ranges given in the question
    
//     public int search(ArrayReader reader, int target) {
        
//         if(reader.get(0) == target) {
//             return 0;
//         }
        
//         int low = 0, high = (int) Math.pow(10,4) - 1;
        
//         while(low <= high) {
//             int mid = low + (high - low) / 2;
//             if(target == reader.get(mid)) {
//                 return mid;
//             }
//             else if(reader.get(mid) >= reader.get(low)) {
//                 if(target >= reader.get(low) && target <= reader.get(mid)) {
//                     high = mid - 1;
//                 }
//                 else {
//                     low = mid + 1;
//                 }
//             } else {
//                 if(target >= reader.get(mid) && target <= reader.get(high)) {
//                     low = mid + 1;
//                 }
//                 else {
//                     high = mid - 1;
//                 }
//             }
//         }
            
//         return -1;
//     }
}
