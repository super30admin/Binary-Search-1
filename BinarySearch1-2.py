# Time complexity: O(log(n))
# Space Complexity: O(1) 
# Approach: Binary search; if (mid == low or nums[mid-1] < nums[mid]) and (mid == high or nums[mid] > nums[mid+1]), we found the peak, return it's index.
# Elseif nums[mid] > nums[mid+1], now we need to confirm for mid-1, so we move left (high = mid-1), else (nums[mid]<nums[mid+1]) we move right side.
# Also nums[-1] = nums[n] = -∞, so we might get 0th or last element index as answer, as 1st elem < 0th elem > -∞ and last second elem < last elem > -∞
# if no peak found, return -1


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
        while target >= reader.get(high):
            low = high
            high = 2 * high
        
        while low <= high:
            mid = low + (high - low) // 2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1