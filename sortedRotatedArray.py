# // Time Complexity : O(lg n) 
# // Space Complexity : O(1)  
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums)-1
        
        while low <= high:
            mid = low + (high - low)//2
            
            if nums[mid] == target: return mid
            
            elif nums[low] <= nums[mid]: # search space is sorted
                if nums[low] <= target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if nums[high] >= target > nums[mid]: 
                    low = mid + 1
                else:
                    high = mid - 1
                
        return -1