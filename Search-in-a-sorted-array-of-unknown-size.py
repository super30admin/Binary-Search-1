#Reference Video: https://youtu.be/m7GyMS67110
# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        #Initially consider left as 0 and right as 1 since they are the minimum values possible for left and right
        left = 0
        right = 1
        
        #we have to keep checking until the target falls before right pointer in the array
        #if not found, make the right as left and multiply the right by 2 to obtain new right pointer
        while (reader.get(right) < target):
            left = right
            right = right * 2

        #perform binary search     
        while (left <= right):
            mid = (left + right) // 2
            if reader.get(mid) == target:
                return mid
            elif target < reader.get(mid):
                right = mid - 1
            else:
                left = mid + 1
                
        return -1
        