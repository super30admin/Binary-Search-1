// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Approach 1: Input constraints mention that secret.length <= 10^4, hence chose end = 999 and applied binary search

//Approach 2: chose end = target - reader.get(0) because the array elements are unique and sorted, 
// If first value is n, only options would be from n to target.

class Solution {
    public int search(ArrayReader reader, int target) {
        if(reader == null) {
            return -1;
        }
//Sol 1: Input constraints mention that secret.length <= 10^4, hence chose end = 999
//         int start = 0, end = 9999;
        
//         while(start <= end) {
//             int mid = (start + end)/2;
            
//             if(target == reader.get(mid)) {
//                 return mid;
//             }
            
//             if(target < reader.get(mid)) {
//                 end = mid - 1;
//             } else {
//                 start = mid + 1;
//             }
//         }
        
//         return -1;
        
//Sol 2: chose end = target - reader.get(0) because the array elements are unique and sorted, 
// If first value is n, only options would be from n to target.
        
        int start = 0, end = target - reader.get(0);
        
        while(start <= end) {
            int mid = (start + end)/2;
            
            if(target == reader.get(mid)) {
                return mid;
            }
            
            if(target < reader.get(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return -1;
    }
}