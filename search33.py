# Time - O(logn)
# space - O(1)

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if (len(nums) == 0 or nums == None):
            return -1

        low = 0
        high = len(nums) - 1
        
        while (low <= high):
            mid = low + (high - low)//2 # in order to integer overflow
            
            if (target == nums[mid]):
                return mid
                
            if (nums[low] <= nums[mid]): # it doe snot have unsorted array
                if (nums[low] <= target and target < nums[mid]):
                    high = mid - 1
                else:
                    low = mid + 1 # go to unsorted part
                    
            else: # left part is not sorted for sure 
                if (nums[mid] < target and target <= nums[high]):
                    low = mid + 1
                else:
                    high = mid -1
                    
        return -1