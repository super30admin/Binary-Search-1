"""
Time = O(log n)
space = O(log n) -- recursive calls use stack space
Successfully excecuted on leetcode

Approach:
Here,Assume array has maxinum number of integers, which is equivalebnt to filling the maximum number of integers in the redundant positions. Then this is also an ordered array, we can directly use a binary search method to find it
 
"""


# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader, target):
        left = 0
        right = float('inf')
        while left < right:
            mid = left + (right-left)//2
            x = readrer.get(mid)
            if x == target:
                return mid
            elif x<target:
                left = mid + 1
            else:
                right = mid
        return -1 # Target not found
    
    