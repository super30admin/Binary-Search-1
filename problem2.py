# Time Complexity : O(log N) 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution(object):
    def search(self, nums, target):
        left,right = 0, len(nums)-1
        
        while left <= right:
            pivot = (left+right)//2
            if target == nums[pivot]:
                return pivot
            if nums[left] <= nums[pivot]:
                if target > nums[pivot] or target < nums[left]:
                    left = pivot +1
                else:
                    right = pivot - 1
                    
            else:
                if target < nums[pivot] or target > nums[right]:
                    right = pivot-1
                else:
                    left = pivot + 1
        return -1
        