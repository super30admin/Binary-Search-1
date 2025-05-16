# Time Complexity - O(log (k) + log (m))
# Space Complexity - O(1)
class Solution:
    def search(self, reader, target):
        hi = 1
        while reader.get(hi) < target:
            hi *= 2
        low = hi // 2
        while low <= hi:
            mid = low + (hi - low) // 2
            val = reader.get(mid)
            if val == target:
                return mid
            elif val > target:
                hi = mid - 1
            else:
                low = mid + 1
        return -1
