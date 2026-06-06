# https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
# Time Complexity O(log(n)) here both loops have same range so it wont be m+n
# Space Complexity O(1)


class Solution:
    def search(self, reader: "ArrayReader", target: int) -> int:
        low, high = 0, 1
        while reader.get(high) < target:
            high *= 2

        while low <= high:
            mid = (low + high) // 2
            if reader.get(mid) == target:
                return mid
            if reader.get(mid) > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1
