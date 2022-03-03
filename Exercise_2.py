class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        #Brute Force
        # if len(nums)>1:
        #     for i in range(len(nums)):
        #         if target == nums[i]:
        #             return i
        #         else:
        #             False
        # else: 
        #     False
        
        #Time Complexity = O(logn)
        #Space Complexity = O(1)
        
        l = 0 
        r = len(nums) - 1
        while l <= r:
            mid = (l + r) // 2
            if nums[mid] == target:
                return mid
            
            if nums[l] <= nums[mid]:
                if target > nums[mid] or target < nums[l]:
                    l = mid +1
                else:
                    r = mid - 1
            else:
                if target < nums[mid] or target > nums[r]:
                    r = mid - 1
                else:
                    l = mid + 1
        return -1