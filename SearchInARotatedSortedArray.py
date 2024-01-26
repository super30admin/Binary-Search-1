'''
Determine which part of the array we are in - left/right sorted array 
Check if the target lies in the sorted section else check the other section
TC: O(logn)
SC: O(1)
'''
from typing import List
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        i,j = 0, len(nums)-1
        while i<=j:
            mid = (i+j)//2
            if target == nums[mid]:
                return mid
            #Left sorted array
            if nums[i] <= nums[mid]:
                if target >= nums[i] and target < nums[mid]:
                    j = mid - 1
                else:
                    i = mid + 1

            #Right sorted array
            else:
                if target > nums[mid] and target <= nums[j]:
                    i = mid + 1
                else:
                    j = mid - 1
        return -1

s = Solution()
print(s.search([4,5,6,7,0,1,2], 0))
print(s.search([4,5,6,7,0,1,2], 3))
print(s.search([3,1], 1))
print(s.search([2], 2))
print(s.search([], 2))