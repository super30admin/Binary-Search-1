
# Time Complexity : O(logn)
#  Space Complexity : O(1)
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach :
            # 1. The main idea of this problem is getting the higher bound for binary search as its an infinite array
            # 2. Keep increasing the higher bound by a factor of 2 till the target is lesser than element at high.
            #    Factor 2 is used here as if we take it as 3/4 or something larger than that then it might make the higher bound search faster but range to do binary search will be huge
            # 3. Oncec we get the higher bound then just perform binary search, find the target else return -1


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
        low = 0
        high = 1
        while(reader.get(high) < target):
            low = high
            high = high * 2
        print(high)    
        return self.binarySearch(low, high, target, reader)
        
    def binarySearch(self, low, high, target, reader):
        while low <= high:
            mid = low + int((high-low)/2)
            x = reader.get(mid)
            if x == target:
                return mid
            elif target <= x:
                high = mid - 1
            else:
                low = mid + 1
        return -1
            