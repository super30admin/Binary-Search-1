#Time Complexity = O(logn)
#Successfully compiled and run in Leetcode

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = (low + high) // 2

            if nums[mid] == target:
                return mid

            if nums[low] <= nums[mid]: #main logic where we check if low val is less than mid val
                if nums[low] <= target <= nums[mid]: #interval check between low val and mid val
                    high = mid - 1
                else: #interval check between high val and mid val
                    low = mid + 1
            else: #if low val is not less than mid val
                if nums[mid] <= target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
        return -1