# ----------------------------
# Time Complexity - O(log N) m is the number of elements queried
# Space Complexity - O(1)
# ----------------------------


class Solution:
    def search(self, reader, target):
        lo = 0
        hi = target - reader.get(0)

        while lo <= hi:
            mid = lo + (hi - lo) // 2

            value = reader.get(mid)
            if value == target:
                return mid
            elif value < target:
                lo = mid + 1
            else:
                hi = mid - 1
        return -1
