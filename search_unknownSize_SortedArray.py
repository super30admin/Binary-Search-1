'''
We keep expanding the search space to a window such that, right pointer
points to a value greater than target. left is updated to right pointer
at the same time. Then Binary search operation inside the window.

# Time Complexity : 
    O(log n) - Expand the search space by 2 times. Then Partition the search space into half at each iteration 
# Space Complexity :
    O(1), just 3 pointers (left, right, mid)  
# Did this code successfully run on Leetcode :
    - yes
# Any problem you faced while coding this :
    - Yes
    - Did not think of expanding the search space at first
'''

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        left = 0
        right = 1

        # we keep expanding the space and moving the window until right pointer 
        # has value bigger than target
        while (reader.get(right)<target):
            left = right
            right = right*2
        
        while left<=right:
            mid = (left+right)//2
            
            if reader.get(mid)==target:
                return mid
            
            if target<reader.get(mid):
                right = mid-1
            else:
                left = mid+1
        return -1