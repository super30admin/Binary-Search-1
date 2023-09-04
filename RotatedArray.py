'''// Time Complexity : O(lon(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No'''

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if nums == None or len(nums) == 0:
            return -1

        l = 0
        h = len(nums) - 1
        while l <= h:
            mid = (l+h)//2
            if nums[mid] == target:
                return mid
            elif nums[l] <= nums[mid]:
                if target >= nums[l] and target < nums[mid]:
                    h = mid -1
                else:
                    l = mid + 1
            else:
                if target > nums[mid] and target <= nums[h]:
                    l = mid +1
                else:
                    h = mid - 1
        return -1

