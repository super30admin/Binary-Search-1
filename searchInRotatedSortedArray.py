# Time Complexity : O(lgN)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nope


# Your code here along with comments explaining your approach

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        """ 
        check where in the numArr is increasing/decreasing.
        In other words I need to check where in the array is it sorted then check if target is in sorted.
        (standard binary search with altering left and right values.)
        """
        left = 0
        right = len(nums)-1
        
        while left <= right:
            mid = left + (right-left)//2
            print(mid)
            if nums[mid] == target:
                return mid 
            #rightside is sorted
            elif nums[mid] < nums[left]:
                #target somewhere in the right
                if target <= nums[right] and target > nums[mid]:
                    left = mid + 1
                #in the left
                else:
                    right = mid - 1
            else:
            #leftside is sorted
                #increasing order. left side
                if target >= nums[left] and target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            
        return -1