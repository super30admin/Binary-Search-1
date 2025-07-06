"""
https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/description/

Sorted array of unknown size. You don't know the length of the array. Brute force is linear probe but the length of array can be too large.
Exponential Search --> optimal search. Find the boundaries.

Edge case:
1. element not present
2. 1 element

Time Complexity: O(2logp) = O(logp) where p is the position of the target
Space Complexity: O(1)
"""

class Solution:
    def search(self, reader, target):
      low = 0
      high = 1
      
      # O(logp)
      while reader.get(high) < target: # Find the search boundaries using exponential search
        low = high
        high = high * 2 # You double the size of the search range. You cut the number of steps needed in half, compared to walking linearly.
      
      # O(logp)
      while low <= high: # Binary Search on the boundaries
        mid = (low + high)//2
        
        if reader.get(mid) == target:
          return mid
        
        if target > reader.get(mid):
          low = mid + 1
          
        if target < reader.get(mid):
          high = mid - 1
      return -1