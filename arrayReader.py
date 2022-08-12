# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
# class ArrayReader:
#    def get(self, index: int) -> int:

# Time Complexity: O(logn): This is because each time half of the search space is reduced. We are using Binary Search for it
# Space Complexity: O(1)

# This approach uses the Binary search. We keep decreasing our search space first to find the High Pointer.

# Number 2 is used because of the reason that, if we keep increasing 3, 4, 5 ... Eventually it is going to n, because, 1/3 is better than 1/2, 1/4 better than 1/2 .... 1/n better than 1/n-1
# Once we get the range where the target lies, then it is a simple Binary search


class Solution:
    def search(self, reader: "ArrayReader", target: int) -> int:
        self.low = 0
        self.high = 1

        while reader.get(self.high) < target:
            self.low = self.high
            self.high *= 2

        while self.low <= self.high:
            self.mid = self.low + (self.high - self.low) // 2
            if reader.get(self.mid) == target:
                return self.mid
            elif reader.get(self.mid) > target:
                self.high = self.mid - 1
            else:
                self.low = self.mid + 1

        return -1
