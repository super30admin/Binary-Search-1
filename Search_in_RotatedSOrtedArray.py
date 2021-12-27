# // Time Complexity : O(logN)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach



class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low =0 
        high = len(nums) -1
        
        while low <= high:
            mid = low + (high-low)//2
            
            if(nums[mid] == target):
                return mid
            
            #left side is sorted
            elif nums[low] <= nums[mid]:
                # if number is in left side
                if nums[low] <= target and nums[mid]> target:
                    high = mid - 1
                else:
                    low = mid + 1        
            # right side is sorted
            else:
                if nums[mid]< target and nums[high]>= target:
                    low = mid+1
                else:
                    high = mid-1
                    
        return -1
                    
# Input: nums = [4,5,6,7,0,1,2], target = 0
# Output: 4                
