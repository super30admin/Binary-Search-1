# Time Complexity is O(logn). We are multiplying the right boundary by 2.
# Space Complexity is O(1)
class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        left = 0
        right = 1

        while reader.get(right) < target:
            left = right
            right = left * 2

        while left <= right:
            mid = (left+right)//2

            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) < target:
                left = mid + 1
            else:
                right = mid - 1
        return -1