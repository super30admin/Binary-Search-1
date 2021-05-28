# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:


class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        Time Complexity: O(log n)
        Space Complexity: O(1)
        """
        # assertion
        if reader.get(0) == target: return 0
        
        # first problem is to search for the boundaries
        left, right = 0, 1
        while reader.get(right) < target:
            left = right
            # increase your window
            right *= 2
        
        # second problem is a bit earier, you just complete a binary search
        while left <= right:
            mid = left + ((right - left) // 2)
            num = reader.get(mid)
            
            if num == target: return mid
            if num > target:
                right = mid - 1
            else:
                left = mid + 1
        
        return -1
                