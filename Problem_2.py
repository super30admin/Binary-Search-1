from typing import List

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                return mid
            #left sorted sub array
            elif nums[low] <= nums[mid]:      
                if nums[low] <= target and nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            #right sorted sub array
            else:
                if nums[mid] < target and nums[high] >= target:
                    low = mid + 1
                else:
                    high = mid - 1
        return -1

    # def rotatedSearch(self, nums: List[int], low: int, high: int, target: int) -> int:
        
    #     if low > high:
    #         return -1
        
    #     mid = low + ((high - low) // 2)
        
    #     if nums[mid] == target:
    #         return mid
        
    #     if nums[low] <= nums[mid]:
    #         if target >= nums[low] and target <= nums[mid]:
    #             return self.rotatedSearch(nums, low, mid-1, target)
    #         return self.rotatedSearch(nums, mid+1, high, target)
    
    #     if target >= nums[mid] and target <= nums[high]:
    #         return self.rotatedSearch(nums, mid+1, high, target)
    #     return self.rotatedSearch(nums, low, mid-1, target)
    
    # def search(self, nums: List[int], target: int) -> int:
    #     return self.rotatedSearch(nums, 0, len(nums)-1, target)

obj = Solution()
print(obj.search([4,5,6,7,0,1,2],0))
print(obj.search([4,5,6,7,0,1,2],3))
print(obj.search([1],0))


# Time Complexity : O(log(n))
# Space Complexity: O(1)