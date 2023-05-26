#Time Complexity : O(log n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

#Initially I used a while loop to find the ending position of the list of elements by checking for the specific out of bound value. Then I used normal binary search to find the target and its position.

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        start, end = 0, 10
        while reader.get(end) == pow(2,31) - 1:
                end = (start + end) // 2
        
        while start <= end:
            mid = (start + end) // 2
            if target > reader.get(mid):
                start = mid + 1
            elif target < reader.get(mid):
                end = mid - 1
            else:
                return mid
        return -1