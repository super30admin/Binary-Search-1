"""
Approach: Here, in this problem we will find the midpoint and get the mid element and we will check which side is sorted and whicher side is sorted we will make sure
another thing that our target is in that range and if it is in there we will do binary search in there and if not then we will binary search on another side.

Time Complexity : O(logn)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if len(nums) == 0:
            return -1
        low = 0
        high = len(nums) - 1
        while(low<=high):
            mid = low + (high-low)//2
            print(mid)
            if nums[mid] == target:
                return mid
            if nums[mid] >= nums[low]:
                # left sorted
                if target < nums[mid] and target >= nums[low]:
                    high = mid - 1
                else: 
                    low = mid + 1
            else:
                # right sorted
                if target > nums[mid] and target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid -1
        return -1


