# Time Complexity : O(log(n)) for all operations
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

#Your code here along with comments explaining your approach
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        low = 0
        high = len(nums)-1
        
        while low<=high:
            mid = low+(high-low)//2
            if nums[mid]==target:
                return mid
            
            elif(nums[mid]<nums[high]):
                # right side is strictly increasing
                if  nums[mid]<=target<=nums[high]:
                    low = mid+1
                else:
                    high= mid-1
            
            else:
                # left side is strictly increaseing
                if  nums[low]<=target<=nums[mid]:
                    high = mid-1
                else:
                    low= mid+1
        
        return -1
        