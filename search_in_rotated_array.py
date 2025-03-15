# 33. Search in Rotated Sorted Array

# Approach:
#     1. Use a modified binary search algorithm that works with rotated sorted arrays
#     2. In each step, identify which half of the array is properly sorted
#     3. Check if the target lies within the sorted half, and adjust search bounds accordingly
    
# Time Complexity: O(log n)
#  - Binary search reduces the search space by half in each iteration
    
# Space Complexity: O(1)
#  - Only constant extra space is used regardless of input size

# Did this code successfully run on Leetcode : YES

def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        # Initialize pointers for binary search
        # Left boundary
        l = 0
        # Right boundary
        r = len(nums)-1

        while l <= r:
            # Calculate middle index - this avoids integer overflow
            # Note: In Python, we typically use (l + r) // 2, but (l + (r-l)//2) is shown for educational purposes
            m = l + (r-l)//2  # Floor division is needed in Python

            # If target found at middle position, return its index
            if nums[m] == target:
                return m

            # Check if left half is sorted
            elif nums[l] <= nums[m]:  # Left half is sorted
                # Check if target is in the sorted left half
                if nums[l] <= target and target < nums[m]:
                    # Target is in left half, discard right half
                    r = m - 1 
                else:
                    # Target is not in left half, discard left half
                    l = m + 1

            # Right half must be sorted
            else:   # Right half is sorted
                # Check if target is in the sorted right half
                if nums[m] < target and target <= nums[r]:
                    # Target is in right half, discard left half
                    l = m + 1
                else:
                    # Target is not in right half, discard right half
                    r = m - 1
        
        
        # If we exit the loop without returning, target was not found
        return -1