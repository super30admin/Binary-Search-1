# 702. Search in a Sorted Array of Unknown Size

# Approach:
#   1. First find the appropriate search space using exponential search
#   2. Then apply binary search within the identified boundaries
    
# Time Complexity: O(log n)
#   - Finding the range takes O(log n) with exponential growth
 #   - Binary search within the range takes O(log n)
    
# Space Complexity: O(1)
#   - Only constant extra space is used regardless of input size

# Did this code successfully run on Leetcode : YES


def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        # Initialize left boundary at index 0
        l = 0
        # Initialize right boundary at index 1 (will be expanded exponentially)
        r = 1

        # First phase: Find the search range using exponential search
        # Keep doubling the right boundary until we find a value >= target
        while reader.get(r) < target:
            # Move left boundary to current right boundary
            l = r
            # Double the right boundary (exponential growth)
            r = r * 2


        # Second phase: Use binary search within the identified range [l, r]
        while l <= r:
            # Calculate middle index to divide the search space
            m = l + (r-l)//2

            # Case 1: If the middle element equals target, we found it
            if reader.get(m) == target:
                return m

            # Case 2: If the middle element is greater than target
            if reader.get(m) > target:
                r = m - 1

            # Case 3: If the middle element is less than target
            else:
                # Target must be in the right half, so discard left half
                l = m + 1


        # If we exit the loop without returning, target was not found
        return -1