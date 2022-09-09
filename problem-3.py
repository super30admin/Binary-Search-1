# Search in a Sorted Array of Unknown Size

# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        if reader.get(0) == target:
            return 0
        
        #double the boundary until you find an element that is greater than target
        l, r = 0, 1
        while reader.get(r) < target:
            l = r + 1
            r *= 2
        
        while l <= r:
            mid = (l + r) // 2
            num = reader.get(mid)
            
            if num == target:
                return mid
            if num > target:
                r = mid - 1
            else:
                l = mid + 1
        
        #element not found
        return -1