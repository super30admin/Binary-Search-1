# Time Complexity : O(1)
# Space Complexity : O(lon n))
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l=0 #lower bound
        u=len(nums)-1 #upper bound
		
        if not nums:
            return -1
        
        while l<=u:
            mid=(l+u)//2 #find mid value to find efficien process for search target element
            
            if target==nums[mid]:
                return mid
            
            if nums[l]<=nums[mid]:
                if nums[l]<=target<=nums[mid]:
                    u=mid-1
                else:
                    l=mid+1
            else:
                if nums[mid]<=target<=nums[u]:
                    l=mid+1
                else:
                    u=mid-1
        return -1
