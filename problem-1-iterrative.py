"""
Approach

1. Find the middle element
2. One of the property of roatated sorted array is that either the left part or the right part of the mid is always sorted
3. if the left part is sorted and target in in the range of left part then continue binary search in left part otherwise
search in right part

"""


# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l,r = 0, (len(nums)-1)     
        while l<=r:
            m = l + (r-l)//2
                        
            if nums[m] == target:
                return m
            
            if (nums[l]<=nums[m]):
                # strictly increaseing
                if target>= nums[l] and target<nums[m]:
                    r = m-1
                else:
                    l=m+1            
            else:                
                if target> nums[m] and target<=nums[r]:
                    l = m+1
                else:
                    r=m-1
        return -1
                        
        