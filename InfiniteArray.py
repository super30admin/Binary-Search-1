"""
Keep increasing search bounds by doubling right until reader.get(right) >= target.
Apply binary search between left and right.
Return mid if reader.get(mid) == target, else adjust left or right accordingly.
"""

"""
Time Complexity
for boundary: O(log N) (N is index, reader.get(T) ≥ target) and Binary search: O(log N)
Therefore, overall O(log N)
Space Complexity: O(1)
"""
# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class InfiniteArray:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        left, right = 0, 1

        
        while reader.get(right) < target:
            left = right
            right *= 2

        while left <= right:
            mid = (left + right) // 2
            val = reader.get(mid)

            if val == target:
                return mid
            elif val > target:
                right = mid - 1
            else:
                left = mid + 1

        return -1

