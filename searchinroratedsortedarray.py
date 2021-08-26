"""
TC: O(logn)
Sc:O(1)
We will be checking which side is sorted and based upon that we will either re-assign value of low and high and recalculating the
value of mid untile mid==target, we will return the value of mid
:return
"""

class Solution:
    def searchRange(self, nums):
        if not nums or len(nums)==0:
            return -1
        low=0
        high=len(nums)-1
        while (low<=high):
            mid=(low+high)//2
            if nums[mid]==target:
                return mid
            elif nums[low]<=nums[mid]:
                print("left side is sorted")
                if nums[low]<=target and nums[mid]>target:
                    high=mid-1
                ##if elemeent is lying on the non sorted side
                else:
                    low=mid+1
            else:
                print("right side is sorted")
                if nums[mid]<target and nums[high]>=target:
                    low=mid+1
                ##if element is lying on the non sorted side
                else:
                    high=mid-1

        return 0
nums=[4,5,6,7,0,1,2]
target=5
solve=Solution()
print(solve.searchRange(nums))
