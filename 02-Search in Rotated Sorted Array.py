# Problem 2 - Search in Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if nums == None or len(nums) == 0:
            return -1
        
        n = len(nums)
        low = 0
        high = n - 1

        while low <= high:
            mid = (low + high) // 2
            if nums[mid] == target:
                return mid
            # left sorted
            if nums[low] <= nums[mid]:
                # check if num lies in sorted part
                if nums[low] <= target and nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            # right sorted
            else:
                if nums[mid] < target and nums[high] >= target:
                    low = mid + 1
                else:
                    high = mid - 1
        return -1