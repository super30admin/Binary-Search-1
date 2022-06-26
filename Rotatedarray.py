#Time complexity: O(LogN)
#Space complexity: O(1)
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low=0
        high=len(nums)-1
        while low<=high:
            mid=low+(high-low)//2
            #Finding if the middle element is our target
            if nums[mid]==target:
                return mid
            #checking if the mid element is in left half or right half of sorted portion
            elif nums[mid]>=nums[low]:
                #It means our mid element is in left half
                if target<nums[mid] and target>=nums[low]:
                    high=mid-1
                else:
                    low=mid+1
            else:
                #it means our middle element is in righter half
                if target>nums[mid] and target<=nums[high]:
                    low=mid+1
                else:
                    high=mid-1
        return -1
        