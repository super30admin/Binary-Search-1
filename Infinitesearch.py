# // Time Complexity : O(log n)
# // Space Complexity : O(1) as no extra space being used
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach
'''
Here we follow increasing the search space twice approach
first we need to find the range in which the target present
  we took two pointers low and high, move high in steps of 2 times prev position and low to previous high position
Then apply binary search on that range

'''

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = 1
        while reader.get(high) < target:
            low = high
            high *= 2
        while low <= high:
            mid = low + (high-low)//2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) <= target:
                low = mid + 1
            else:
                high = mid - 1
        return -1
            
        
