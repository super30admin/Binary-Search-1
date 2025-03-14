# This approach first expands the search boundary exponentially (right <<= 1) until the target is within range, ensuring logarithmic efficiency. 
# Once the target is within [left, right], a binary search is performed to locate it in O(log M) time. 
# By combining exponential expansion and binary search, the overall complexity remains O(log N).
# Space Complexity: O(1)


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
        
        left, right = 0, 1

        while reader.get(right) < target:
            left = right
            right <<=1
        
        while left<=right:
            mid = left + (right - left)//2
            mid_val = reader.get(mid)

            if mid_val == target:
                return mid
            elif mid_val > target:
                right = mid-1
            else:
                left = mid+1
        return -1
        