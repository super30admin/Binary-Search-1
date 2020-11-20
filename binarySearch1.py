""" 
Time Complexity : O(logN)
Space Complexity : O (1) ;since storig only values in constants
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this :
- Had forgotten to add the <= to compare the target element in both if and else condition
"""
# Your code here along with comments explaining your approach

"""
Binary search approach:
- regular binary search approach except, since the array is not sorted do the following below:
-- where it lies towards the left side or the right side of the array
-- whether the target lies in-between the range determined in the above step
"""

class Solution:
    def search(self, nums, target) -> int:
        if len(nums) == 0:
            return -1
        
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low +(high - low)//2
            if nums[mid] == target:
                return mid
            
            if nums[low] <= nums[mid]:
                if target >= nums[low] and target <= nums[mid]:
                    high = mid -1
                else:
                    low = mid + 1
            else:
                if target >= nums[mid] and target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid -1
            
        return -1

s = Solution()
print(s.search([4,5,6,7,0,1,2],0))