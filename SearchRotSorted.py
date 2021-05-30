#Time complexity: O(log n) because 1 bin search
#Space complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        l = 0
        r = len(nums) - 1
        
        while l<= r:
            mid = l + (r-l)//2
            if nums[mid] == target:
                return mid
            elif nums[l] <= nums[mid]:
                #left sorted
                if target<nums[mid] and nums[l] <= target:
                    r = mid - 1
                else:
                    l = mid + 1
            else:
                # right sorted
                if target<=nums[r] and nums[mid] < target:
                    l = mid + 1
                else:
                    r = mid - 1
        return -1