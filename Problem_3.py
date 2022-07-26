"""
 Time Complexity : O(logn), where n is number of elements
 Space Complexity : O(1)
 Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : No

 our code here along with comments explaining your approach

 Problem 2 : Search in a Sorted Array of Unknown Size

            You must write an algorithm with O(log n) runtime complexity.
"""
# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        slow= 0
        fast = 2
        
        while reader.get(fast) <= target:
            slow = slow + 1
            fast = fast * 2
            
        while slow <= fast:
            mid = (slow + fast) //2
            if reader.get(mid) == target:
                return mid
            elif (reader.get(mid) > target):
                fast = mid -1
            else:
                slow  = mid + 1
                
        return -1