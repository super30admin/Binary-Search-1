class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        def binarySearch(left, right):
            while left <= right:
                mid = left + (right - left) // 2
                if target == reader.get(mid):
                    return mid
                elif reader.get(mid) > target:
                    right = mid - 1
                elif reader.get(mid) < target:
                    left = mid + 1
            return -1

        left = 0
        right = 1
        while reader.get(right) < target:
            left = right
            right *= 2

        return binarySearch(left, right)

    '''
        left, right = 0, 1
        while reader.get(right) < target:
            left = right
            right *= 2

        while left <= right:
            mid = ((right + left) //2)
            num = reader.get(mid)

            if num == target:
                return mid
            if num > target:
                right = mid - 1
            else:
                left = mid + 1

        return -1
    '''
