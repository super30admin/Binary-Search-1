"""
Time = O(log n)
space = O(log n) -- recursive calls use stack space
Successfully excecuted on leetcode

Approach:
1. left rotated: pivot at the left side of the origin sorted array, nums[mid] >= nums[left]
    search in nums[left] to nums[mid-1] if nums[left] <= target < nums[mid] else, search right side
2. right rotated: pivot at the right side of the origin sorted array, nums[mid] < nums[left]
    search in nums[mid+1] to nums[right] if nums[mid] < target <= nums[right] else, search left side
"""

class SolutionRecursion: # --- Recursion Approach -- failed in leetcode with maximum recursion depth exceeded error
    
    def helper(self,nums,left,right,target):

        mid = left + (right-left)//2
        if nums[mid] == target:
            return mid
        #if left side is sorted and has target
        if nums[left] <= target <nums[mid]:
            return self.helper(nums,left,mid-1,target)

        #if right side is sorted and has target
        elif nums[mid] <= target <nums[right]:
            return self.helper(nums,mid+1,right,target)
        
        # right side is pivoted
        elif nums[mid] > nums[right]: 
            return self.helper(nums, mid+1, right, target)
        
        else: # left side is pivoted
            return self.helper(nums,left, mid-1,target)

    def search(self, nums: List[int], target: int) -> int:
        
        left = 0
        right = len(nums)-1
        if not nums:
            return -1
        return self.helper(nums,left,right,target)
    
    
    
    
class SolutionIteraticve: # --- Accepted in leetcode : Time = O(logn), space = O(1)
    
    def search(self,nums,target):
        left = 0
        right = len(nums) - 1
        while left <= right:
            mid = (left + right) // 2
            # if found target value, return the index
            if nums[mid] == target:
                return mid
            
            # Check if left rotated or right rotated
           
            if nums[mid] >= nums[left]: # left rotated
                if nums[left] <= target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            else: # right rotated
                if nums[mid] < target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1
        return -1 # Target value does not exist

        