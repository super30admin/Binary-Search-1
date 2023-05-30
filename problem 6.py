#Time Complexity : O(logn)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        # find the pivot point
        left, right = 0, len(nums) - 1
        while left < right:
            mid = (left + right) // 2
            if nums[mid] > nums[right]:
                left = mid + 1
            else:
                right = mid
        pivot = left
    
    # perform binary search on the appropriate half of the array
        if target >= nums[pivot] and target <= nums[-1]:
            left, right = pivot, len(nums) - 1
        else:
            left, right = 0, pivot - 1
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        return -1