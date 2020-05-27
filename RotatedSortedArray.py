# Time Complexity : O(log(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes!
# Any problem you faced while coding this : I had an almost working recursive solution
# which was working for every array but 1 but the concept was made clear after the session.

# Your code here along with comments explaining your approach
class Solution(object):
    def search(self, nums, target):
        if len(nums) == 0:
            return -1
        # bound variables for array traversal
        left = 0
        right = len(nums)-1
        # terminating condition for while loop
        while left <= right:
            mid = left + (right - left) / 2
            # if element present at mid index
            if target == nums[mid]:
                return mid
            # left array sorted
            elif nums[left] <= nums[mid]:
                # target present in left sorted array
                if nums[left] <= target < nums[mid]:
                    right = mid -1
                # target present in right array
                else:
                    left = mid + 1
            # else right array sorted
            else:
                # target present in right sorted array
                if nums[mid] < target <= nums[right]:
                    left = mid + 1
                # target present in left array
                else:
                    right = mid - 1
        # element not present
        return -1

nums = [4,5,6,7,8,1,2,3]
target = 8
s = Solution()
print(s.search(nums, target))
