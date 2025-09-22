# Problem 3: Search in Infinite Sorted Array (https://leetcode.com/problems/search-in-infinite-sorted-array/)

# Time Complexity: O(log n) where n is the number of elements in the array
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# We first find the bounds where the target could be by exponentially increasing the high index.
# Once the bounds are found, we perform a standard binary search within those bounds.
# We use the ArrayReader interface to access elements, which returns 2^31 - 1 for out-of-bounds indices.


class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        
        if not reader:
            return None

        low = 0 
        high = 1

        while reader.get(high) < target:
            low = high 
            high = high*2

        while low <= high:
            mid = low + (high - low)//2

            if reader.get(mid) == target:
                return mid

            elif reader.get(mid) > target:
                high = mid - 1
            else:
                low = mid + 1

        return -1 