# // Time Complexity : 2 * O(p) = O(p) --> where p is the position of the element to be searched
# // Space Complexity : O(1)


class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        low, high = 0, 1
        while reader.get(high) < target:
            low = high+1
            high *=2

        while low <= high:
            mid = low + (high-low)//2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                high = mid - 1
            else:
                low = mid + 1

        return -1