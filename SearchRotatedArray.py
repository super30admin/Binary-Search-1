# Time Complexity - O(log(N))

# Space Complexity - O(1)

# Approach
# I try to find the maximum element in the array and then binary search using that as a pivot.

class Solution:
    def binarySearch(self, nums, low, high, target):
        if high >= low:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] > target:
                return self.binarySearch(nums, low, mid - 1, target)
            else:
                return self.binarySearch(nums, mid + 1, high, target)
        else:
            return -1

    def search(self, nums: List[int], target: int) -> int:
        max = float('-inf')
        for i in range(len(nums)):
            if nums[i] > max:
                max = nums[i]
                pivot = i
        print(max, pivot)
        if (nums[pivot] == target):
            return pivot
        elif (nums[0] > target):
            return self.binarySearch(nums, pivot + 1, len(nums) - 1, target)
        else:
            return self.binarySearch(nums, 0, pivot, target)

