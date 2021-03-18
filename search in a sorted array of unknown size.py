class Solution:
    def function_search(self, reader, target):
        low = high // 2
        high = 1

        while reader.get(high) < target:
            high = high * 2

        while low < = high:
            mid = low + (high - low) // 2
            check = reader.get(mid)

            if check == target:
                return mid

            if mid > target:
                high -= 1
            else:
                low += 1

        return -1

