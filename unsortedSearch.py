# Leetcode 33. Search in Rotated Sorted Array

# Time Complexity : O(log n) where n is the size of the array.
# Space Complexity : O(1) for iterative search and O(log n) for the recursive search where n is the size of the array.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Since the array is rotated arouna pivot, when we divide the array into two parts atleast one part
# is going to be sorted. First we see if the left half is sorted or right. Once we determine that, we can check
# if the target is present on that. If its not we check on the other side

# Your code here along with comments explaining your approach
class Solution:
    def binary_iterative(self, nums, target, low, high):
        while low <= high:
            mid = low + ((high - low)//2)
            if nums[mid] == target:
                return mid

            # Left sorted
            if nums[low] <= nums[mid]:
                if (nums[low] <= target < nums[mid]):  # target is the left side
                    high = mid - 1
                else:  # target is on the right
                    low = mid + 1

            # Right sorted
            else:
                if (nums[mid] < target <= nums[high]):  # target is on the right
                    low = mid + 1
                else:                              # target is the left side
                    high = mid - 1
        return -1

    def binary_recursive(self, nums, target, low, high):
        while low <= high:
            mid = low + ((high - low)//2)

            if nums[mid] == target:
                return mid

            # Left sorted
            if nums[low] <= nums[mid]:
                if (nums[low] <= target < nums[mid]):  # target is the left side
                    return self.binary_recursive(nums, target, low, mid-1)
                else:  # target is on the right
                    return self.binary_recursive(nums, target, mid+1, high)

            # Right sorted
            else:
                if (nums[mid] < target <= nums[high]):  # target is on the right
                    return self.binary_recursive(nums, target, mid+1, high)
                else:                              # target is the left side
                    return self.binary_recursive(nums, target, low, mid-1)
        return -1

    def search(self, nums: List[int], target: int) -> int:

        high = len(nums)-1
        low = 0

        return self.binary_iterative(nums, target, low, high)
        # return self.binary_recursive(nums,target,low,high)
