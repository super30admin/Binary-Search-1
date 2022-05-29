# Time complexity: O(log(n))
# Space Complexity: O(1)
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low=0
        high=len(nums)-1
        while low<high:
            mid=low+(high-low)//2
            if nums[mid]==target:
                return mid
            #left side is sorted 
            elif nums[low]<=nums[mid]:
                if target<nums[mid] and target>=nums[low]:
                    high=mid
                else:
                    low=mid+1
            else:
                if target>nums[mid] and target<=nums[high]:
                    low= mid+1
                else:
                    high=mid
        if low == high and nums[low]==target:
            return low
        return -1
            
        