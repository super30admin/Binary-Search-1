# Time Complexity : O(log n) — exponential search takes O(log k) to find a bound, then binary search takes O(log k) again; overall O(log n) where n is array length
# Space Complexity : O(1) — only a fixed number of pointers/variables are used

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low, high = 0, 1

        # 1) Exponential search to find a range where target could lie
        while reader.get(high) < target:
            low = high
            high *= 2

        # 2) Standard binary search between low and high
        while low <= high:
            mid = low + (high - low) // 2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                high = mid - 1
            else:
                low = mid + 1

        # 3) Not found
        return -1


# Mock ArrayReader for local testing
class ArrayReader:
    def __init__(self, nums):
        self.nums = nums

    def get(self, index: int) -> int:
        # returns 2^31-1 if index is out of bounds
        if index < 0 or index >= len(self.nums):
            return 2**31 - 1
        return self.nums[index]


if __name__ == "__main__":
    sol = Solution()

    # Example 1: target present
    reader1 = ArrayReader([-1, 0, 3, 5, 9, 12])
    print(sol.search(reader1, 9))    # expected 4

    # Example 2: target absent
    reader2 = ArrayReader([-1, 0, 3, 5, 9, 12])
    print(sol.search(reader2, 2))    # expected -1

    # Edge: target at first position
    reader3 = ArrayReader([1, 2, 3, 4, 5])
    print(sol.search(reader3, 1))    # expected 0

    # Edge: completely out of range
    print(sol.search(reader3, 10))   # expected -1

