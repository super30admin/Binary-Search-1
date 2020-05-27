"""

    Student : Shahreen Shahjahan Psyche
    
    The code passed all the test cases in Leetcode

    Time Complexity : O(log N)
    Space Complexity : O(1) 

"""

from typing import List

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        if len(nums) == 0:
            return -1
        
        # Initializing the iteration variables
        l = 0
        r = len(nums)-1
        
        while(l<=r):
            mid = (l+r)//2
            if nums[mid] == target:
                return mid
            
            # Checking whether to move to right or left segment of the array
            if nums[mid] >= nums[l]:
                if target >= nums[l] and target<nums[mid]:
                    r = mid - 1
                else:
                    l = mid + 1
                    
            else:
                if target <= nums[r] and target>nums[mid]:
                    l = mid + 1
                else:
                    r = mid - 1
        return -1
               