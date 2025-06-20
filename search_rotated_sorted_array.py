# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach in three sentences only


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l = 0
        h = len(nums) - 1
        while l <= h:
            mid = l + (h - l) // 2  # preventing overflow
            if nums[mid] == target:  # if mid element is equal to target, return its index
                return mid
            elif nums[l] <= nums[mid]:  # checking if L.H.S is sorted
                if nums[l] <= target < nums[mid]:  # checking if target lies in the L.H.S
                    h = mid - 1  # If element lies in L.H.S bring "h" to L.H.S
                else:
                    l = mid + 1  # element not in L.H.S bring "l" to R.H.S
            else:  # If it reaches it means R.H.S is sorted
                if nums[mid] < target <= nums[h]:  # checking if target lies in the R.H.S
                    l = mid + 1  # if element in R.H.S bring "l" to R.H.S
                else:
                    h = mid - 1  # element not in R.H.S brinh "h" to L.H.S
        return -1  # If element not found return -1

