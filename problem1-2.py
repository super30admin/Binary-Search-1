# Time Complexity : O(log(n))
# Space Complexity : 0(n)

# Did this code successfully run on Leetcode : 
# YEs

# Any problem you faced while coding this : 

# Your code here along with comments explaining your approach

#Binary Search Approach

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l=0
        r=len(nums)-1
        while r>=l:
            m=(l+r)//2
            print(m)
            if nums[m]==target:
                return m
            if nums[l] <= nums[m]:
                if target >= nums[l] and target <= nums[m]:
                    r=m-1
                else:
                    l=m+1
            else:
                if target <= nums[r] and target >= nums[m]:
                    l=m+1
                else:
                    r=m-1                
        return -1