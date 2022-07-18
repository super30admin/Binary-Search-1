# Time Complexity : O(log n)
# Space Complexity : O(log n)
# Did this code successfully run on Leetcode : YES
# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
# class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        #check if target is first element itself or not
        if reader.get(0) == target:
            return 0

        #initialize low and high
        low = 0
        high = 1

        #increase value of high as per as requirement
        while reader.get(high) <= target:
            low = high
            high = high * 2

        #simple binary search
        while low <= high:
            mid = (low + high) // 2
            value = reader.get(mid)

            if value == target:
                return mid
            elif target < value:
                high = mid - 1
            else:
                low = mid + 1

        return -1
