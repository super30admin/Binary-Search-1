# Time Complexity : O(logn)
# Space Complexity :    O(1)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach




class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        left = 0
        right = len(nums)-1
        
        #loop to find the index of smallest element - modified BS
        while left<right:
            mid = left+(right-left)//2
            
            if nums[mid]>nums[right]:
                left = mid+1
            else:
                right = mid
            
        start = left        
        left = 0
        right = len(nums)-1
        
        #find the search space
        if target>=nums[start] and target<=nums[right]:
            left = start
        else:
            right = start
        
        while(left<=right):
            mid = left+(right-left)//2
            
            if target==nums[mid]:
                return mid
            if target<nums[mid]:
                right = mid-1
            else:
                left = mid+1
        
        return -1