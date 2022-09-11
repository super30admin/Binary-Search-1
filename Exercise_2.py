# Time Complexity: O(logn)
# Space Complexity: O(1)
# Any problem you faced while coding this : No
# Did this code successfully run on Leetcode: Yes

class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        left = 0
        right = len(nums) - 1
        
        while(left<=right):
            mid = left + right-left/2
            if nums[mid] == target:
                return mid
            
            #left part is sorted
            if nums[left]<=nums[mid]:
                if nums[left]<=target and target<nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            else:
                if target<=nums[right] and target>nums[mid]:
                    left = mid + 1
                else:
                    right = mid - 1
        return -1