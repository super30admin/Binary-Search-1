#   ques: 33. Search in Rotated Sorted Array

#   Time Complexity :
#   O(log n)

#  Space Complexity :
#  O(1)

#  Did this code successfully run on Leetcode :
#  Yes

#  Any problem you faced while coding this :
#  No

#  Your code here along with comments explaining your approach

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        l, h = 0, len(nums) - 1
        
        while (l <= h):
            
            m = (l+h)//2
            
            # Checking if target element is at mid index
            if (nums[m] == target):
                return m
            
            # Checking if left side of array is sorted
            if (nums[l] <= nums[m]):
                # Checking if target element is at left side of array
                if (nums[l]<=target and nums[m]>target):
                    h = m - 1
                else:
                    l = m + 1
            # If left is not sorted right will be sorted
            else:
                # Checking if element is in right side of array
                if (nums[m] < target and nums[h] >= target):
                    l = m + 1
                else:
                    h = m - 1
                    
        return -1
                        
                