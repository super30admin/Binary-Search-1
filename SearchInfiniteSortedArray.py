# Time Complexity : O(log(mn)) where m is # of steps to find the range and n is the number of elements in the range
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        # Find the range
        low = 0 
        high = 1

        while reader.get(high) <= target:
            low = high
            high = high*2

        while low <= high:
            mid = low + (high-low)//2
            midVal = reader.get(mid)
            if midVal == target:
                return mid
            if midVal < target:
                low = mid + 1
            else:
                high = mid - 1

        return -1