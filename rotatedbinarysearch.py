#Time Complexity : O(log n)
#Space Complexity : O(1) no auxiallary space used
#Did your code executed on Leetcode : Yes

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        
        while(low <= high):
            mid = low + (high - low)//2
            
            if nums[mid] == target:
                return mid
            
            elif nums[mid] >= nums[low]:
                if nums[low] <= target and nums[mid] > target:
                    high = mid -1
                else:
                    low = mid + 1
            else:
                if nums[mid] < target and target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
        return -1
                    
                
                
                
                
                
                
                
            
