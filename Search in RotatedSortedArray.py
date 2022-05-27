""""// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""


class Solution:

    def search(self, nums, target):
        l = 0
        r = len(nums) - 1
        while l <= r:
            mid = l + (r - l) // 2
            if nums[mid] == target:
                return mid
            else:
                if nums[l] <= nums[mid]:
                    if nums[l] <= target < nums[mid]:
                        r = mid - 1
                    else:
                        l = mid + 1

                else:

                    if nums[mid] < target <= nums[r]:
                        l = mid + 1
                    else:
                        r = mid - 1

        return -1
ob1 = Solution()
print(ob1.search([4,5,6,7,8,0,1,2], 8))