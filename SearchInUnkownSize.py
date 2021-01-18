# Search in a sorted array of unknown size (https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/)
# Time complexity: O(log(n)); n=no of elements in array 
# Space complexity: O(1); 
# Did this code successfully run on Leetcode : Yes
# Approach: Binary search

class Solution:
    def search(self, reader, target: int) -> int:

        low = 0
        high = 1

        # Increase the scopr by 2 until you hit the interval where target may lie
        while target > reader.get(high):
            low = high
            high = 2 * high

        # Perform binary search in that interval
        return self.bSearch(reader, target, low, high)

    def bSearch(self, reader, low, high):
        while low <= high:
            mid = low + (high-low) // 2
            element = reader.get(mid)
            if element == targer:
                return mid
            elif element > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1