"""
Approach:
-> Take two pointers low and high, initialize low to 0 and high to 1
-> Expand the search space until target is within reader.get(high) - that is find search space.
-> Apply regular binary search on the search space to find the target

Time Complexity:
O(log n) - binary search

Space Complexity:
O(1) - constant space
"""
# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low, high = 0, 1

        # key point: find the search space - expand until target is within reader.get(high)
        while reader.get(high) <= target:
            low = high # move low to high's position
            high = high * 2 # make jumps of length 2 times (binary search property: increase search space by 2 times)

        
        # we found search space where our target is present, so apply regular binary search
        while low <= high:
            
            mid = low + (high-low)//2

            if reader.get(mid) == target:
                return mid

            # element in left half, update high pointer
            elif target < reader.get(mid):
                high = mid - 1

            # element in right half, update low pointer
            else:
                low = mid + 1
        
        return -1