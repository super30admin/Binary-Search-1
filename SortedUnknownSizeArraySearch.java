// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Using 2 binary search
class SortedUnknownSizeArraySearch {
    public int search(ArrayReader reader, int target) {
        int low=0, high = 1;
        while(reader.get(high) < target){
            low = high;
            high = high * 2;

        }

        while(low <=high) {
            int mid = low + (high-low)/2;
            if(reader.get(mid) == target){
                return mid;
            }
            else if(target > reader.get(mid)) {
                low = mid + 1;
                
            }
            else {
                high = mid - 1;
            }
           
        }
        return -1;
        
    }
}

//Another approach
// class Solution {
//     public int search(ArrayReader reader, int target) {
//         int low=0, high = 9999;
//         // while(reader.get(high) < target){
//         //     low = high;
//         //     high = high * 2;

//         // }

//         while(low <=high) {
//             int mid = low + (high-low)/2;
//             if(reader.get(mid) == target){
//                 return mid;
//             }
//             else if(target > reader.get(mid)) {
//                 low = mid + 1;
                
//             }
//             else {
//                 high = mid - 1;
//             }
           
//         }
//         return -1;
        
//     }
// }