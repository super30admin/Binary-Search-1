def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        left, right = 0, 1
        while target > reader.get(right):
            left=right
            right = right * 2
            
        while left <= right:
            mid = (left+right)>>1

            if reader.get(mid) == target:
                return mid
            else:
                if reader.get(mid) < target:
                    left = mid + 1
                else:
                    right = mid - 1
        return -1