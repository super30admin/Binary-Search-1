# Time Complexity : O(logn)
# Space Complexity :O(1)
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        # using binaray search

        l=0
        h=len(nums)-1
        while l<=h:
            mid=l+(h-l)//2
            if nums[mid]==target: return mid
            if nums[l]<=nums[mid]:# checking first half is sorted or not
                if nums[l]<=target and target<nums[mid]:
                    h=mid-1
                else:
                    l=mid+1
            elif nums[mid]<target and target<=nums[h]:
                    l=mid+1
            else:
                    h=mid-1
        return -1
