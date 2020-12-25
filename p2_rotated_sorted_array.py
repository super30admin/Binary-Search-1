# Time Complexity : O(logN) Since binary search
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : YES 
# Any problem you faced while coding this : starting it few didn't pass but later added the edge case
#Can I cut down few things to make more clear of my solution

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        # if nums none will return -1
        if nums == None:
            return - 1
        
        # Perform Binary search
        left = 0
        right = len(nums) - 1
        
        while left <= right:
            mid = (left + right) // 2
            
            # if target find then return mid position index
            if target == nums[mid]:
                return mid
            
            # when nums is rotated we need these two condition to check
            if nums[left] <= nums[mid]:
                if nums[left] <= target <= nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            
            else:
                if nums[right] >= target >= nums[mid]:
                    left = mid + 1
                else:
                    right = mid - 1
        return -1