class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        res=[-1,-1]
        if len(nums)==0:
            return res
        l=0
        h=len(nums)-1
        while nums[l]<nums[h] :
            mid=l+(h-l)/2
            if nums[mid]>target:
                h=mid-1
            elif nums[mid]<target:
                l=mid+1
            else:
                if nums[l]==nums[mid]:
                    h=h-1
                else:
                    l=l+1
        if nums[l]==nums[h]==target:
            res[0]=l
            res[1]=h
        return res 
            
        