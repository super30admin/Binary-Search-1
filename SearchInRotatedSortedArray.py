'''
Time Complexity : O(log n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
Your code here along with comments explaining your approach:
     Applied binary search by keeping track of left, right and mid variables
     comparing element at mid and left too, to limit the scope.
'''

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        n = len(nums)
        left = 0
        right = n-1

        while left<=right:
            mid = (left + right)//2
            if nums[mid] == target:
                return mid
            elif nums[mid]>=nums[left]:
                if target>=nums[left] and target<nums[mid]:
                    right = mid-1
                else:
                    left = mid+1
            else:
                if target>nums[mid] and target<=nums[right]:
                    left = mid+1
                else:
                    right = mid-1
        
        return -1

        