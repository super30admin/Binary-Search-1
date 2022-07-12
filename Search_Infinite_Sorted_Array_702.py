# Search in Infinite sorted array: https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

# Time Complexity: O(logn) - Applying Binary Search
# Space Complexity: O(1) - No extra space needed
# Leetcode Problem solved successfully?: yes
# Code:
class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        if reader.get(0) == target:
            return 0
        
        low = 0
        high = 1
        while(reader.get(high) < target):
            low = high
            high = high * 2
        
        while(low<=high):
            mid = low + (high - low) // 2
            print(mid)
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1

# Approach: Since the array size is not known, we first try to identify the range where our target  will belong and then apply binary search on it.
