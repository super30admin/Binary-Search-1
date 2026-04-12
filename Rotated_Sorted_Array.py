# Time Complexity : O(log n) - binary search.
#  Space Complexity : O(1) - storing only pointers.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#Your code here along with comments explaining your approach in three sentences only
#Search using binary search check if middle is the target if yes return.
#If not check if left is sorted or right is sorted. If left is sorted check if target is in the range of left else check in right. 
class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        
        l , r = 0 , len(nums) - 1
        while l <= r:
            mid = l + (r - l) // 2
            if target == nums[mid]:
                return mid

            #left sorted
            if nums[l] <= nums[mid]:
                #right side
                if target > nums[mid] or target < nums[l]:
                    l = mid + 1
                else:
                    r = mid - 1
            # Right sorted
            else:
                #left side
                if target < nums[mid] or target > nums[r]:
                    r = mid - 1
                else:
                    l = mid + 1
        return -1
