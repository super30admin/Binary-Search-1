# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach:
# 1. We will use binary search to find the target element.
# 2. We will first check if the left portion of the array is sorted or not.
# 3. If the left portion is sorted, we will check if the target lies within the left sorted portion.
# 4. If the left portion is not sorted, then we definitely have a right sorted portion.
# 5. We will
#    a. check if the target lies within the right sorted portion.
#    b. If yes, we will update the left pointer to mid + 1.
#    c. If not, we will update the right pointer to mid - 1.

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l, r = 0, len(nums) - 1
        while l <= r:
            mid = l + (r-l)//2
            # return index if target is found
            if nums[mid] == target:
                return mid
            # check if we have a left sorted array
            if nums[mid] >= nums[l]:
                # check if target lies within the left sorted portion
                if target < nums[mid] and target >= nums[l]:
                    r = mid - 1
                else:
                    l = mid + 1
            # if the left portion of the array is not sorted, then we definitely have a right sorted portion
            else:
                # check if target lies within the right sorted portion
                if target > nums[mid] and target <= nums[r]:
                    l = mid + 1
                else:
                    r = mid - 1
        return -1