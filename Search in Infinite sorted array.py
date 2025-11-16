
# Assign low =0 and high =1. While the target is grater than array[high], assign the low to 
# high and double the high. Perform binary search on the obtained range by calculating mid and
# check if the target == array[mid], if yes, return mid. If target<array[mid],high = mid-1 else
#  low = mid+1

# Time complexity: O(logn)
# Space complexity: O(1)

# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation.
# class ArrayReader:
#     def get(self, index: int) -> int:

class Solution(object):
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        # Your code here
        
        low = 0
        high = 1
        while(reader.get(high)<target):
            low=high
            high = 2* high
        while low<=high:
            mid = (low+high)//2
            if reader.get(mid)==target:
                return mid
            else:
                if reader.get(mid)>target:
                    high=mid-1
                else:
                    low=mid+1
        return -1
        
        pass
