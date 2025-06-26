# Time Complexity : O(log n)
# Space Complexity : O(1)
#Did this code successfully run on Leetcode : No
#Any problem you faced while coding this : No
# Three line explanation of solution in plain english:
# 1. The solution uses an exponential search to find the range where the target might be located.
# 2. It then applies binary search within that range to find the exact index of the target.
# 3. The reader.get method is used to access elements, simulating a scenario where the array size is unknown.


class Solution:
    def search(self, reader, target):
        low = 0
        high = 1

        # Expand the search range exponentially
        # until the value at high index is greater than or equal to the target
        while reader.get(high) < target:
            low = high
            high *= 2

        return self.binarySearch(reader, target, low, high)
    #
    # Perform binary search within the determined range
    def binarySearch(self, reader, target, low, high):
        while low <= high:
            mid = low + (high - low) // 2
            # Use reader.get to access the value at mid
            val = reader.get(mid)

            # Check if the value at mid is equal to the target
            if val == target:
                return mid
            elif val > target:
                high = mid - 1
            else:
                low = mid + 1
        # If the target is not found, return -1
        return -1
