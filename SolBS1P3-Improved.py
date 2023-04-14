"""
-Time Complexity : O(logN)
-Space Complexity : O(1)
-Did this code successfully run on Leetcode : Yes
-Any problem you faced while coding this : No

-Your code here along with comments explaining your approach in three sentences only
1. We didn't have a high value, we incremented with a multiplier of 2 starting from high = 1
2. low = 0, high = 1, until you hit num[high] > target, make low = high and high = high * 2 
once you surpass target, then using BS find the target within the current low and high boundary.
"""
class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = 1
        while reader.get(high) < target:
            low = high
            high *= 2
        if reader.get(high) == target:
            return high
        else:
            while low <= high:
                mid = low + (high-low)//2
                if reader.get(mid) == target:
                    return mid
                elif reader.get(mid) < target:
                    low = mid + 1
                else:
                    high = mid - 1
        return -1