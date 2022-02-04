# Time Complexity : O(logN); 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No, since it was discussed in class

# Approach: Binary Search


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        s, e = 0, len(nums) - 1
        while(s<=e):
            mid = (s+e)//2
            if nums[mid] == target:
                return mid
            elif nums[mid] <= nums[e]:
                if nums[mid] < target and target <= nums[e]:
                    s = mid+1
                else:
                    e = mid-1
            else:
                if nums[s] <= target and target < nums[mid]:
                    e = mid-1
                else:
                    s = mid+1
        return -1
