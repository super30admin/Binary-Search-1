# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
import math


class Solution:
    def search(self, reader: list, target: int) -> int:
        readerLen = len(reader)
        if readerLen == 1 and reader[0] == target:
            return target

        low, high = 0, 1
        while reader[high] < target:
            if high * 2 < readerLen:
                high = high * 2
            else:
                high = readerLen - 1
            low = high

        while low <= high:
            mid = low + (high - low)//2
            if reader[mid] == target:
                return mid
            if reader[mid] < target:
                low = mid + 1
            elif reader[mid] > target:
                high = mid - 1
        return -1
        #     mid = i + (j - i)//2
        #     v = reader[mid]
        #     if v == target:
        #         return mid
        #     if target > v:
        #         i = mid + 1
        #         j = j*2
        #     else:
        #         j = mid - 1
        # return -1


a = Solution()
print(a.search(reader=[1, 2, 3, 4, 5, 6, 7, 8, 9, 12, 14, 16, 23, 26,
                       27, 29, 30, 37, 39, 45, 48, 51, 62, 78, 92], target=92))
