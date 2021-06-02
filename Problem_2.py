"""
Time Complexity : O(log(n)) 
Space Complexity : O(1)

"""

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l = 0
        h = len(nums) - 1 
        
        while l <= h:
            mid = l + (h - l)//2
            
            if nums[mid] == target:
                return mid 
            
            elif nums[mid] >= nums[l]: 
                
                if nums[mid] >= target and target >= nums[l]:
                    h = mid - 1 
                else:
                    l = mid + 1 
                
            else:
    
                if nums[mid] <= target and target <= nums[h]:
                    l = mid + 1 
                else:
                    h = mid - 1
                
        return -1 
            