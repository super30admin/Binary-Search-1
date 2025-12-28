''' Time Complexity : O(log n)
    Space Complexity : O(1) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

   Your code here along with comments explaining your approach

   Approach : In Rotated sorted array, either of the side id always sorted.
                1. Finding sorted side (left or right)
                2. If left is sorted; check if target lies in left side - update low and high variables accordingly
                3. If right is sorted; check if target lies in right side - update low and high variables accordingly.

'''

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l , h = 0, len(nums)-1
        while l <= h:
            mid = (l+h) // 2
            if nums[mid] == target:
                return mid
            if nums[l] <= nums[mid]:
                # left is sorted
                if nums[l] <= target and nums[mid] >= target:
                    h = mid - 1
                else:
                    l = mid + 1
            else:
                # right is sorted
                if nums[mid] <= target and nums[h] >= target:
                    l = mid + 1
                else:
                    h = mid - 1
        return -1   

            


            