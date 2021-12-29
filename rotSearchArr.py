"""

Time: OlogN
space: O1
"""

class Solution:
    def search(self, nums: list[int], target: int) -> int:
       
        
        low, high = 0, len(nums)-1
        
        while low <= high:
            mid = (low + high) // 2
             #base case, target = mid
            if target == nums[mid]:
                return mid
            #check which side is sorted
            #one side is at least correct, if left is sorted..
            elif nums[low] <= nums[mid]:
                #perform bi search, check if target is here
                if target >= nums[low] and target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            else: #right side is sorted
                if target > nums[mid] and nums[high] >= target:
                    low = mid + 1
                else:
                    high = mid - 1;
        return -1;