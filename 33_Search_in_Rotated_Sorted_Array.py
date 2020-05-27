# Time Complexity : O(logn)
# 
# Space Complexity : O(1)
# 
# Did this code successfully run on Leetcode : Yes
# 
# Any problem you faced while coding this : No
#
# Problem Approach
# 1. At each iteration either the left half or the right half of the mid index is sorted. This allows us to manipulate the start and end indexes accordingly.
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        start, end = 0, len(nums)-1
        
        while start <= end:
            mid = (start+end) // 2
            if nums[mid] == target: # Target found
                return mid
            elif nums[start] <= nums[mid]: # The left half of the mid index is sorted
                if nums[start] <= target and target < nums[mid]: # True, if the target lies in left  of mid index
                    end = mid-1
                else:
                    start = mid+1
            else:
                if target > nums[mid] and target <= nums[end]: # True, if the target lies in right of mid index
                    start = mid +1
                else:
                    end = mid -1
        return -1