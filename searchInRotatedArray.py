// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if(nums == None or len(nums) == 0):
            return -1
        low=0
        high=len(nums)-1
        mid=0
        
        while(low<=high):
            mid = int(low + ((high-low)/2))
            if nums[mid]==target:
                return mid
            if nums[low]<=nums[mid]:
                if nums[low]<=target and nums[mid]>target:
                    high = mid-1
                else:
                    low = mid+1
            else:
                if nums[mid]<target and nums[high]>=target:
                    low=mid+1
                else:
                    high=mid-1
        return -1
            
            
        
        
        