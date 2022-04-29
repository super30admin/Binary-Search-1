#Time complexity: O(logn)
#Space complexity: O(1)
class Solution:
    def search(self, nums, target):
        low,high=0,len(nums)-1
        while(low<=high):
            mid=(low+high)//2
            if nums[mid]==target:
                return mid
            if nums[mid]>=nums[low]:
                if target>= nums[low] and target <=nums[mid]:
                    high=mid-1
                else:
                    low=mid+1
            elif nums[mid]<=nums[high]:
                if target>= nums[mid] and target <=nums[high]:
                    low=mid+1
                else:
                    high=mid-1         
        return -1