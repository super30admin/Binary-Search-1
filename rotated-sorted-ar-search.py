# // Time Complexity :O(logn)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        if(len(nums)==0):
            
            return
        low=0
        high=len(nums)-1
        while low<=high:
            
            mid=(low+high)//2
            if nums[mid]==target:
                return mid
            if nums[low]<=nums[mid]:
                if(nums[low]<=target and nums[mid]>target):
                    high=mid-1
                else:
                    low=mid+1
            else:
                if(nums[mid]<target and nums[high]>=target):
                    low=mid+1
                else:
                    high=mid-1
        return -1
                    
            