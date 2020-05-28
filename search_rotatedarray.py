"""
Time Complexity: O(logN) where N is the number of elements
Space Complexity:O(1) -no extra space used

Code execution: Complete

Explaination: since the array is sorted but rotated, we first check which part of the array is sorted. After finding which part is sorted, we are checking if the target lies in that particular range
"""


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if len(nums) == 0 or nums == None:
            return -1
        low = 0
        high = len(nums) - 1
        while (low <= high):
            mid = (low + high) // 2
            print(mid)
            if nums[mid] == target:
                return mid
            elif nums[low] <= nums[mid]:  # checking if left is sorted
                if nums[low] <= target and nums[mid] >= target:  # checkiing if the target lies in that range
                    high = mid - 1  # if it lies, move the high pointer towards the middle


                else:
                    low = mid + 1
            elif nums[high] >= nums[mid]:  # check if right sorted
                if nums[high] >= target and nums[mid] <= target:
                    low = mid + 1
                else:
                    high = mid - 1
        return -1
