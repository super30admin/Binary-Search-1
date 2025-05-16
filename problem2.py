#t.c. => O(log(n))
#s.c. => O(1)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : No
#approach => directly apply binary search on the two slopes- left slope and right slope
#Try to find the condition to update the search space accoriding to the target

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        n = len(nums)
        l, r = 0, n - 1
        while l <= r:
            mid = l + (r - l)//2
            if nums[mid] == target:
                return mid
            if nums[mid] >= nums[l]: #left slope
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