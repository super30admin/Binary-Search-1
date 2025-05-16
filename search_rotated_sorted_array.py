"""
Time Complexity = O(log n) where n is number of elements in list
Space Complexity = O(1), no extra space is used
Find the sorted half, perform binary search on that half
"""
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l = 0
        h = len(nums) - 1

        while l <= h:
            mid = l + (h - l) // 2
            if nums[mid] == target:
                return mid
            elif nums[l] <= nums[mid]:
                # left sorted
                if nums[l] <= target <= nums[mid]:
                    h = mid - 1
                else:
                    l = mid + 1
            else:
                # right sorted
                if nums[mid] <= target <= nums[h]:
                    l = mid + 1
                else:
                    h = mid - 1
        return -1
