from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low, high = 0, len(nums) - 1

        while(low<= high):
            if nums[low] == target: return low
            if nums[high] == target: return high
            mid = (low + high) // 2
            if nums[mid] == target: return mid
            if nums[low] <= nums[mid]:
                if(nums[low] <= target and nums[mid] > target):
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if(nums[high] >= target and nums[mid] < target):
                    low = mid + 1
                else:
                    high = mid - 1
        return -1
sol = Solution()
print(sol.search([4,5,6,7,0,1,2],3))