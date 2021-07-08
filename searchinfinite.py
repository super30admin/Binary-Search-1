# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

# keep the high pointer at the maximum size 
# Time complexity - O(log n) asymptotically
# Space complexity - O(1)
# Did this code run on leetcode? - yes
class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        low, high = 0, 10000
        while low<=high:
            mid = low + (high-low)//2
            midelem = reader.get(mid)
            # if the mid pointer does not exists, shift it.
            if midelem == target:
                return mid
            elif midelem == 2147483647:
                high = mid - 1
            else:
                lowelem = reader.get(low)
                if lowelem <= target <= midelem: # check if the value lies in the left side.
                    high = mid - 1
                else:
                    low = mid + 1
            
        return -1

    
# by repeatedly increasing the low, high pointer.
# we increase the low and high pointer till the point, our target value is between low and high.
# if our low pointer reaches the end, return -1. (target is greater than the elements in the array)
# else,
# search the target in the range low and high.
# if the middle element is the same as the target, return mid.
# else, update the low and high pointers based on the value of the target to reduce the window in the next step.
# Time complexity - O(log n) asymptotically
# Space complexity - O(1)
# Did this code run on leetcode? - yes

class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        # prevlow, prevhigh = 0, 100
        low, high = 0, 10
        while reader.get(low) != 2147483647:
            if target >= reader.get(high):
                low = high + 1
                high = 2*high 
            else:
                break
                
        return self.__bsearch(low, high, reader, target)
    
    # Function for binary search
    def __bsearch(self, low, high, reader, target):
        while reader.get(low) <= target <= reader.get(high) and low <= high:
            mid = low + (high-low)//2
            midelem = reader.get(mid)
            lowelem = reader.get(low)
            # if the mid pointer does not exists, shift it.
            if midelem == target:
                return mid
            elif midelem == 2147483647 or lowelem <= target <= midelem:
                high = mid - 1
            else:
                low = mid + 1
        return -1
      
      