#LC: yes, 33
#problems: NA
#TC: O(logn). n is len of nusm, we reject one side
#SC: O(1)
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if nums is None or len(nums) == 0:
            return -1
        
        low = 0
        high = len(nums) - 1
        
        while low <= high:
            
            mid = low + (high - low)//2
            if nums[mid] == target:
                return mid
            
            #left side sorted
            elif nums[low] <= nums[mid]:
                
                #target lies in left side
                if target >= nums[low] and target < nums[mid]:
                    high = mid -1
                else: 
                    low = mid + 1
            
            #right side is sorted
            elif nums[mid] <= nums[high]:
                
                #tagert lies in right side
                if target > nums[mid] and target <= nums[high]:
                    low = mid +1
                else: 
                    high = mid - 1  
        return -1
        