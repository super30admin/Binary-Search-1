# // Time Complexity : O(Log N)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach in three sentences only
class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        lo, hi = 0, 1

        #Finding the hi boundary - O(logN)
        while reader.get(hi) <= target:
            if reader.get(hi) == target:
                return hi
            hi = hi * 2
        
        #Do Binary search using this lo and hi boundaries - O(logN)
        while lo <= hi:
            mid = (lo+hi)//2

            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) < target:
                lo = mid + 1
            else:
                hi = mid - 1
        
        return -1
