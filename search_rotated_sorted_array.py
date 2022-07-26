
# Time complexity : O(logn)
# Space complexity: O(1)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No 

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        low = 0
        high = len(nums) - 1
        
        while low < high:
            mid = (low + high) //2
            if nums[mid] == target:
                return mid
            
            elif nums[low] <= nums[mid]:
                if target >= nums[low] and target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            elif nums[mid] < nums[high]:
                if target > nums[mid] and nums[high] >= target:
                    low = mid + 1
                else:
                    high = mid - 1
                    
            else:
                break
                
        if nums[high] == target:
            return high
        else:
            return -1
                
                    
                    
