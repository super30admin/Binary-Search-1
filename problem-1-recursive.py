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
    
    def binarySearch(self,nums, left, right,target):    
        if left>right:
            return -1
        mid = left + (right-left)//2
        if nums[mid] == target:
            return mid
        if (nums[left]<=nums[mid]):
            # strictly increaseing
            if target>= nums[left] and target<nums[mid]:
                right = mid-1
            else:
                left=mid+1
        else:                
            if target> nums[mid] and target<=nums[right]:
                left = mid+1
            else:
                right=mid-1
        return self.binarySearch(nums,left,right,target)          
    
          
    def search(self, nums: List[int], target: int) -> int:
        return self.binarySearch(nums,0,len(nums)-1,target)
                        
        