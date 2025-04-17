#TIme Complexityy :O(LogT)
# Space COmplexity : O(1)
# Able to run on leetcode :dont have leetcode premium
class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low, high = 0, 1
        while reader.get(high) < target:
            low = high
            high *= 2

        while low <= high:
            mid = (low + high) // 2
            val = reader.get(mid)

            if val == target:
                return mid
            elif val > target:
                high = mid - 1
            else:
                low = mid + 1

        return -1
