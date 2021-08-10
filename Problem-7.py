"""
Time complexity: O(logn)
Space complexity: O(1)
Approach: keep low = 2 and high = low ^ 2. In a loop, while low <= high, Calculate mid.
            if mid = target, return mid
            Everytime mid is less than target,
            if high is not out of bound, update low = mid + 1 and high = low ^ 2
            if mid is greater than target or mid is out of bounds,
             high = mid - 1

"""

class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        if reader.get(0) == target:
            return 0
        if reader.get(1) == target:
            return 1
        if reader.get(2) == target:
            return 2
        else:
            low = 2
            high = low ** 2
            while (low <= high):

                mid = low + (high - low) // 2

                if reader.get(mid) == target:
                    return mid
                elif (reader.get(mid) == 2 ** 31 - 1) or reader.get(mid) > target:
                    high = mid - 1
                else:
                    if reader.get(high) < target:
                        low = mid + 1
                        high = low
                    else:
                        low = mid + 1
            return -1