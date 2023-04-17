"""
-Time Complexity : O(logN)
-Space Complexity : O(1)
-Did this code successfully run on Leetcode : Yes
-Any problem you faced while coding this : No

-Your code here along with comments explaining your approach in three sentences only
1. We didn't high value, we found it using Binary search. 
2. We used the fact that we know  1<= secret.length <= 10^4 and that secret[i]
return 10^31-1 if i is out of bounds. Find last index where you don't get this
value, that would be your high. O(logN)
3. then simply perform BS, to find target in array, of which the length is now
known.
4. Return -1 is target is not present in the array.
-
"""


class Solution:
    def findHigh(self, reader):
        low = 0
        high = pow(10, 4)
        while low <= high:
            mid = low + (high-low)//2
            if reader.get(mid) == pow(2, 31) - 1:
                high = mid - 1
            else:
                low = mid + 1
        return mid

    def search(self, reader: 'ArrayReader', target: int) -> int:
        high = self.findHigh(reader)
        low = 0
        while low <= high:
            mid = low + (high-low)//2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1