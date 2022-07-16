# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
# class ArrayReader:
#    def get(self, index: int) -> int:

"""
Approach 1: Search linearly - but since size is unknown, we will keep moving one step at a time till we
find the element. O(n) time solution
Approach 2: Binary search : We can use this as the array is Sorted. So we can initialize low at 0 and high at 1
while array of high is less than target, we keep moving low to high and high = high*2
Then once we are out of that loop, apply binary search on low, high and target
"""


class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = 1
        while reader.get(high) < target:
            low = high
            high *= 2
        while low <= high:
            # to avoid mid going out of bounds of integer range, we use low +(high-low)//2
            # in some static languages if integer is capped at 2^32 after that it will throw error
            # in python it may just become long
            # integer overflow condition - Java
            mid = low + (high - low) // 2

            if reader.get(mid) == target: return mid
            if reader.get(mid) > target:
                high = mid - 1
            else:
                low = mid + 1

        return -1
