from pip import List
#Time Complexity = O(logn)
#Space Complexity = 1

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if(nums is None or len(nums)==0):
            return -1
        low = 0
        high = len(nums)-1
        while(low<=high):
            mid = int(low + ((high-low)/2)) #to avoid integer overflow
            if(nums[mid]==target):
                return mid
            elif(nums[low]<=nums[mid]):
                if(target>=nums[low] and target<nums[mid]):
                    high = mid-1
                else:
                    low = mid+1
            else:
                if(target<=nums[high] and target>nums[mid]):
                    low = mid+1
                else:
                    high = mid-1
        return -1

        