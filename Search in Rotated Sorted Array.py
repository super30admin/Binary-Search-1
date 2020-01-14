class Solution:
    
    def search(self, nums, target):  
        
        if not nums:
            return -1
        
        low = 0
        high = len(nums) - 1
        
        while low <= high:
            mid = (low+ high) // 2
            
            if target == nums[mid]:
                return mid
            
            if nums[low] <= nums[mid]:
                if nums[low] <= target <= nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
                    
            else:
                if nums[mid] <= target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
                    
        return -1
            
nums = [4,5,6,7,0,1,2]
target = 0

obj = Solution()
print(obj.search(nums, target))            
        
        
            
            
        
        
            
                
                
                
                
        
