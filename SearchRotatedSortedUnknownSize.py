'''
The reader interface returns - 2^31 - 1, if index is out-of-bounds, so we choose and arbitrary high value, 
in this case 20000. After that we do a standard a binary search
Space complexity - O(1) - BS does not use extra space
Time complexity - O(log-n)
'''
class SearchRotatedSortedUnknownSize:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        left, right = 0, 20000

        while left <= right:
            mid = left + (right - left) // 2
            middleValue = reader.get(mid)
            if middleValue == target:
                return mid
            elif middleValue > target:
                right = mid - 1
            else:
                left = mid + 1
        return -1