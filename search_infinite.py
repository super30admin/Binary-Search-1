# Time Complexity :O(log n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Not sure how to implement this problem in normal console
class Solution:
    def search(self, reader, target):
        lo, hi = 0, 10_000
        while lo <= hi: 
            mid = lo + hi >> 1
            val = reader.get(mid)
            if val < target: lo = mid + 1
            elif val == target: return mid 
            else: hi = mid - 1
        return -1