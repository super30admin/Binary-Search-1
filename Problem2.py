from typing import List
'''
Time Complexity: O(log n)
Space Complexity: O(1)
'''


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        # Check if the input list is empty or None
        if nums is None or len(nums) == 0:
            return -1

        low = 0  # Initialize the lower bound of the search range
        high = len(nums) - 1  # Initialize the upper bound of the search range

        while low <= high:
            mid = low + (high - low) // 2  # Calculate the middle index

            if nums[mid] == target:  # If the middle element is the target, return its index
                return mid

            if nums[low] == nums[mid]:
                low += 1  # Increment low by 1 to handle duplicate elements
                continue

            if nums[low] <= nums[mid]:
                # If the left side of nums from mid is sorted

                if nums[low] <= target < nums[mid]:
                    high = mid - 1  # Update high to search the left side
                else:
                    low = mid + 1  # Update low to search the right side
            else:
                # If the right side of nums from mid is sorted

                if nums[mid] < target <= nums[high]:
                    low = mid + 1  # Update low to search the right side
                else:
                    high = mid - 1  # Update high to search the left side

        # If the target is not found, return -1
        return -1
