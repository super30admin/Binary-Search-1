# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
from typing import List

class Solution:
    def search(self, nums: List[int], target: int)->int:
        low = 0
        high = 1

        while(nums[high]<target):
            low = high 
            high = 2*high
        
        while(low<=high):
            mid = low + (high-low) //2
            if(nums[mid]==target):
                return mid
            elif(nums[mid] < target):
                low = mid + 1
            else:
                high = mid - 1
        
        return -1

sc = Solution()
nums = [-1, 0, 3, 5, 9, 12]
target = 9
print(sc.search(nums, target))