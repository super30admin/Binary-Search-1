# Time Complexity : O(log(t)) where t is index of target in the array
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        # If target found at index 0, return 0
        if reader.get(0) == target:
            return 0
        
        # Search for boundaries
        # Initially let the boundary be [0, 1]
        lo = 0
        hi = 1
        # Keep on shifting the left boundary to previous right one and doubling the right boundary until element at right boundary is greater than target
        while reader.get(hi) < target:
            lo = hi
            hi = hi << 1
        
        # Binary Search
        while lo <= hi:
            # Calculate mid index for the present search bounds
            mid = (lo + hi) // 2
            # If target found at mid index, return the mid index
            if reader.get(mid) == target:
                return mid
            # If element at mid index is greater than target, search in the left part of the array
            elif reader.get(mid) > target:
                hi = mid - 1
            # If element at mid index is smaller than target, search in the right part of the array
            else:
                lo = mid + 1
        
        # Return -1 if target is not found
        return -1