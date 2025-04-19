#  Time Complexity : O(logn)
#  Space Complexity : O(1)
#  Did this code successfully run on Leetcode : Yes 
#  Any problem you faced while coding this : No


#  Your code here along with comments explaining your approach in three sentences only: We first checks which half (left or right) is properly sorted, then determines if the target lies within that sorted half to adjust the search range accordingly. If the target is found at mid, it returns the index. It returns -1 after exhausting the search space.


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        mid = 0
        while(low <= high):
            mid = low + (high - low)//2
            if nums[mid] == target:
                return mid
            elif nums[low] <= nums[mid]:
                if nums[low] <= target and target <= nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if nums[mid] <= target and target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1 
        return -1