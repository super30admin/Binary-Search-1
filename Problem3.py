## Problem3
# Search in Infinite sorted array (https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/description/)
# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
# class ArrayReader:
#     def get(self, index: int) -> int:

class ArrayReader:
    def __init__(self, arr: list[int]):
        self.arr = arr

    def get(self, index: int) -> int:
        if index < len(self.arr):
            return self.arr[index]
        return 2**31 - 1

class Solution:
    def search(self, reader: "ArrayReader", target: int) -> int:
        # Phase 1: find the low and high range
        low = 0
        high = 1

        # we will keep moving the right pointer by 2x until we reach an index > target index
        while reader.get(high) < target:
            low = high
            high = high * 2
        
        # Phase 2: Binary search
        while low <= high:
            mid = low + (high - low) // 2
            midVal = reader.get(mid)
            if midVal == target:
                return mid

            if midVal > target:
                high = mid - 1
            else:
                low = mid + 1
        
        return -1


# --- Execution Example ---
if __name__ == "__main__":
    # Define your sorted array here
    my_array = [-1, 0, 3, 5, 9, 12, 15, 18, 22, 45, 67, 89]
    target_value = 9

    # Instantiate the mock reader with your array
    reader = ArrayReader(my_array)
    
    # Run the solution
    sol = Solution()
    result = sol.search(reader, target_value)

    print(f"Target {target_value} found at index: {result}")