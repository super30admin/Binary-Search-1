# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
# class ArrayReader:
#    def get(self, index: int) -> int:


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
