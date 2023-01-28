# Could not be tested in leetcode as its premium problem
# Here we first try to find the search space and then apply binary search the on search space.
# To find the search space we increment h pointer twice for each iteration
# until value at h is greater than target. For this search space we apply binary search.
# Time complexity - O(max(logm, logn))
# Space complexity - O(1)
class Solution:

    def search(self, reader: ArrayReader, target: int) -> int:

        l = 0
        h = 1

        while reader.get(h) < target:
            l = h
            h = 2 * h

        while l <= h:
            mid = (l + h) // 2

            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) < target:
                l = mid + 1
            else:
                h = mid - 1

        return -1


