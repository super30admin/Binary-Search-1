// Time Complexity : O(log k)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Finding the correct upper bound from the reader 


// Your code here along with comments explaining your approach in three sentences only

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        l = 0
        r = 1

        while reader.get(r) < target:
            l = r
            r *= 2
    
        while l <= r:
            mid = (l+r) // 2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) < target:
                l = mid + 1
            else:
                r = mid - 1
        
        return -1
