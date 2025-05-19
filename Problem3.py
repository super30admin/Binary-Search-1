"""
I used the approach discussed in the session, where I increased the high pointer range by multiplying it by 2 
After finding the correct range, I performed a binary search to get the index of the target.
Time Complexity: O(log n)
Space Complexity: O(1) 
"""

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = 1
        while reader.get(high) < target:
            low = high
            high *= 2
        while low <= high:
            mid = low + (high - low) // 2
            val = reader.get(mid)
            if val == target:
                return mid
            elif val < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1