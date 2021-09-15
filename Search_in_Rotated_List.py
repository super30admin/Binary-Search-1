
"""
Time Complexity:
O(n)
Space Complexity:
O(n)
"""
class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        sep = 0
        entered = False
        for i,val in enumerate(nums[:-1]):
            if val > nums[i+1]:
                entered = True
                sep = i
        if nums[-1] >= target:
            l,r = sep+1,len(nums) - 1
        else:
            l,r = 0,sep+1
            
        if sep == 0 and not entered:   #This is the twist, here we can't do the above logic if there is no rotation happened
            l,r = 0,len(nums)-1
            
        while l <= r:
            mid = int((l + r)/2)
            if nums[mid] == target:
                return mid
            elif nums[mid] > target:
                r = mid - 1
            else:
                l = mid + 1
        return -1
            