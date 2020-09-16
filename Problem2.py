

class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        left = 0
        right = pow(10,4)+1
        
        while left <= right:
            mid = left + (right - left) // 2
            val=reader.get(mid)
            
            if val == target:
                return mid
            elif val < target:
                left = mid + 1
            elif val == 2147483647 or val > target:
                right = mid - 1
        return -1
