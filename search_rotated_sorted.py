class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        l=0
        r=len(nums)-1
        while l<=r:
            mid = (l+r)/2
            if nums[mid]==target:
                return mid
            if nums[mid]<nums[r]:
                print(nums[mid])
                if target>nums[mid] and target<=nums[r]:
                    l=mid+1
                else:
                    r = mid-1
            else:
                print(nums[mid])
                if target<nums[mid] and target>=nums[l]:
                    r=mid-1
                else:
                    l=mid+1
        return -1
                