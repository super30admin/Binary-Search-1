#Find the sorted part of list
#Check if the target lies among the sorted part, if it does not then check for it in the unsorted part
#Time complexity=O(log n) space complexity=O(1)
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low=0
        high=len(nums)-1
        mid=low+(high-low)//2
        while(low<=high):
            mid=low+(high-low)//2
            if(nums[mid]==target):
                return mid
            elif(nums[low]<=nums[mid]):
                if(target>=nums[low] and target<=nums[mid]):
                    high=mid-1
                else:
                    low=mid+1
            elif(nums[mid]<nums[high]):
                if(target<=nums[high] and nums[mid+1]<=target):
                    low=mid+1
                else:
                    high=mid-1
        return -1

        