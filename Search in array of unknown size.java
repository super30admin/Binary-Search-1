// class Solution:
//     def search(self, reader, target):
//         """
//         :type reader: ArrayReader
//         :type target: int
//         :rtype: int
//         """
        
//         def findEndIndex(target):
//             low = 0
//             high = 1
//             while reader.get(high) < target:
//                 low = high
//                 high = high * 2
//             return low, high
            
            
//         low, high = findEndIndex(target)
//         while low <= high:
//             mid = (low + high) // 2

//             if reader.get(mid) == target:
//                 return mid

//             elif reader.get(mid) > target:
//                 high = mid - 1

//             else:
//                 low = mid + 1
//         return -1



// Time Complexity : O(logn) where n is the index of the target as initially we search for index of target by doubling everytime 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Finding the end index was tricky


// Your code here along with comments explaining your approach: First I found the end index. Later it is simple binary search

class Solution {
    public int search(ArrayReader reader, int target) {
        int low, high;
        int[] a = Solution.findEndIndex(reader, target);
        low = a[0];
        high = a[1];
        
        while (low <= high){
            int mid = low + (high - low) / 2;

            if (reader.get(mid) == target)
                return mid;

            else if(reader.get(mid) > target) 
                high = mid - 1;

            else
                low = mid + 1;
        }
            
        return -1;
    }
    
    public static int[] findEndIndex(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
            
        while (reader.get(high) < target){
            low = high;
            high = high * 2;
            
        }
        
        return new int[] {low, high};
    }
}
            