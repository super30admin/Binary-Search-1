class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        left = 0
        right = len(nums) - 1
        
        
        
        while left <= right:
            mid = (left + right)// 2
            
            if nums[mid] == target:
                return mid
            # left part is sorted
            if nums[left] <= nums[mid]:
                if (target >= nums[left] and target < nums[mid]): # used < for mid because it is already checked in the first condition
                    right = mid - 1
                else:
                    left = mid + 1
            # Right part is sorted        
            else:
                if (target > nums[mid] and target <= nums[right]):
                    left = mid + 1
                else:
                    right = mid - 1
                    
        return -1 # if target is not found then return -1
    
    
    # Time Complexity: O(log(n))
    # Space Complexity: O(1) because no extra space used   
                