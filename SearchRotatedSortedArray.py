#Time Complexity is O(log n) and space complexity is O(1)
class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        l=0
        h=len(nums)-1
        while l<=h:
            mid=l+(h-l)/2
            if nums[mid]==target : return mid
            elif nums[l]<=nums[mid]:
                if nums[l]<=target and nums[mid]>=target :
                    h=mid-1
                else:
                    l=mid+1
            else:
                if nums[h]>=target and nums[mid]<=target :
                    l=mid+1
                else:
                    h=mid-1
        return -1



