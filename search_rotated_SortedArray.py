'''
// atleast one side  will be sorted. 
    if left side is sorted 
        if target is between this sorted 
            update the right
        else
            update left
    else right side is sorted 
        if target is between this sorted
            update left 
        else
            update right

# Time Complexity : 
    O(log n) - Partition the search space into half at each iteration 
# Space Complexity :
    O(1), just 3 pointers (left, right, mid)  
# Did this code successfully run on Leetcode :
    - yes
# Any problem you faced while coding this :
    - Yes
    - Got stuck at the logic first
'''

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if len(nums)==0:
            # sanity check
            return -1
        left = 0
        right = len(nums)-1

        while left<=right:
            mid = (left+right)//2

            if nums[mid]==target:
                return mid
            
            if nums[left]<=nums[mid]: #left sorted
                if target<nums[mid] and target>=nums[left]: #possible in left side
                    right = mid-1 # update right
                else:
                    left = mid+1 # update left
            else: #right sorted
                if target>nums[mid] and target<=nums[right]: #possible in right side
                    left = mid+1 # update left 
                else:
                    right = mid-1 # update right

        return -1
                     
        