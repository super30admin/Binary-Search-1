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
        ##we use .get method to access an element at given location
        if reader.get(0) ==  target:
            return 0
        left = 0
        right = 1
        # we keep on updating our boundary till we don't find a point where the target becomes lower than the element
        while(reader.get(right)<target):
            left = right
            right*=2
        while(left<=right):
            mid = (left + right)//2
            num = reader.get(mid)
            if  num == target:
                return mid
            elif num<target:
                left= mid+1
            else:
                right = mid-1
        return -1
#Time Complexity: O(log(n))
#Space complexity : O(1)