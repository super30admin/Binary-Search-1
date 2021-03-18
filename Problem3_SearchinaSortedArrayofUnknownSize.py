class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        if reader[0] == target:
            return 0

        # search boundaries
        left, right = 0, 1
        while reader[right] < target:
            left = right
            right <<= 1

        # binary search
        while left <= right:
            pivot = left + ((right - left) >> 1)
            num = reader[pivot]

            if num == target:
                return pivot
            if num > target:
                right = pivot - 1
            else:
                left = pivot + 1

        # there is no target element
        return -1

search_element = Solution()
print(search_element.search([-1,0,3,5,9,12], 9))