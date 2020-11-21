class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        print(target)
        # find high such that target <= reader.get(high)
        low, high = 0, 1
        while target > reader.get(high):
            low = high + 1
            high = high * 2

        # binary search for low, high
        return self.binarySearch(reader, low, high, target)

    def binarySearch(self, reader, low, high, target):
        while low <= high:
            mid = low + (high - low) // 2
            potentialMatch = reader.get(mid)
            if target == potentialMatch:
                return mid
            elif target < potentialMatch:
                high = mid - 1
            else:
                low = mid + 1
        return -1