# Search in Infinite sorted array: 

# https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

# Given a sorted array of unknown length and a number to search for, return the index of the number in the array. Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1.

class Solution:
    def binarySearch(reader, target:int, low:int, high:int)-> int:
        while low<=high:
            mid = low + high-low//2
            if reader.get(mid) == target:
                return mid 
            elif reader.get(mid) > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1
    def search(targte:int)->int:
        low,high=0,1
        while reader.get(high) < target:
            low = high 
            high = 2 * high
        return binarySearch(reader, target, low, high) 
    
# Implementation 

# obj1 = Solution()
# obj1.search(22)