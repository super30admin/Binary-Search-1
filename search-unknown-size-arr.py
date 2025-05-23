# Time Complexity : O(logN)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach


class Solution:
    def search(self, reader: 'ArrayReader', target):
        # Step 1: Find a suitable search range (low, high)
        low = 0
        high = 1

        while reader.get(high) < target:
            low = high
            high = 2 * high


        # Step 2: Perform a standard binary search within the found range
        return self.binarySearch(reader, target, low, high)

    def binarySearch(self, reader: 'ArrayReader', target: int, low: int, high: int) -> int:
        while low <= high:
            mid = low + (high - low) // 2 #Integer division - floor  

            # Get the value at mid. 
            val_at_mid = reader.get(mid)

            if val_at_mid == target:
                return mid  # Target found
            elif val_at_mid > target:
                high = mid - 1  # Target is in the left half
            else: # val_at_mid < target
                low = mid + 1   # Target is in the right half
        return -1 # Target not found