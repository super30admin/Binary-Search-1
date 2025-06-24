# Time Complexity: O(1)
# Space Complexity: O(log n)

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        # Step 1: Expand the search boundary exponentially until we go beyond target or hit out of bounds
        left, right = 0, 1
        MAX = 2**31 - 1

        while reader.get(right) < target and reader.get(right) != MAX:
            left = right
            right *= 2

        # Step 2: Standard binary search within the established boundary
        while left <= right:
            mid = left + (right - left) // 2
            val = reader.get(mid)

            if val == target:
                return mid
            elif val > target or val == MAX:
                right = mid - 1
            else:
                left = mid + 1

        return -1
