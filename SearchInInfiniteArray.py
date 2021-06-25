
class Solution:

    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """

        if reader.get(0) == target:
            return 0

        low = 0
        high = 1

        while reader.get(high) < target:
            low = high
            high = high * 2

        while low <= high:
            mid = low + ((high - low) // 2)
            num = reader.get(mid)

            if num == target:
                return mid
            if num > target:
                high = mid - 1
            else:
                low = mid + 1

        return -1
#s= Solution()

# s.search([1,2,3,4],10)