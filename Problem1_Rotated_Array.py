'''
Time Complexity: O(log(n))
Space Complexity: O(1)
Run on Leetcode: YES
Problems: Handling low and high pointer
'''
class Solution:
    def search(self, nums: list[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        while(low <= high):
            mid = low + (high - low)//2
            if nums[mid] == target:
                return mid
            if nums[low] <= nums[mid]:
            # left side is sorted
                if nums[low] <= target and target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
            # right side is sorted
                if nums[mid] < target and target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
        return -1