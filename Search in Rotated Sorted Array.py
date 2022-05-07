# Time Complexity : O(log n), where n indicates the length of the list nums
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l, r = 0, len(nums)-1
        
        while l <= r:
            #m = (l+r)//2
            m = l + (r - l)//2
            #m = (l+r)//2
            
            if nums[m] == target:
                return m
            
            if nums[l] <= nums[m]:  #left sorted
                if nums[l] <= target and target < nums[m]:
                    r = m - 1
                else:
                    l = m + 1
            else:
                if nums[m] < target and target <= nums[r]:
                    l = m + 1
                else:
                    r = m - 1
        return -1
                