#Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this :
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if nums is None or len(nums) == 0:
            return -1
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = (low + high) // 2
            if (nums[mid] == target):
                return mid
            # left portion of array is sorted
            elif nums[low] <= nums[mid]: 
                if (nums[low] <= target and target < nums[mid]):
                    high = mid - 1
                else:
                    low = mid + 1
            # right portion of array is sorted
            else:
                if (nums[mid] < target and target <= nums[high]):
                    low = mid + 1
                else:
                    high = mid - 1
        return -1


