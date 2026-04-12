

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:

        left = 0
        right = 1

        # O(logn)
        while reader.get(i) < target:
            left = right
            right = right * 2
        # O(logn)
        while left <= right:
            mid = left + (right-left)//2
            if reader.get(mid)==target:
                return mid
            elif reader.get(mid) < target: 
                left = mid + 1
            else:
                right = mid - 1

        return -1