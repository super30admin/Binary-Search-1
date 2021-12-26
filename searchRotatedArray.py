# Time Complexity : O(logN)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        while(low<=high):
            mid = (low+high)//2
            if (nums[mid] == target):
                return mid
            elif (nums[mid] >= nums[low]):
                if (target >= nums[low]) and (target < nums[mid]):
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if (target <= nums[high]) and (target > nums[mid]):
                    low = mid + 1
                else:
                    high = mid - 1
        return -1