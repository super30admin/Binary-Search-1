# ----------------------------
# Time Complexity - O(log m*n) m is the number of rows and n is number of columns
# Space Complexity - O(1)
# ----------------------------

class Solution:
    def search(self, nums: List[int], target: int) -> int:
#base case
        if not nums:
            return -1
    
        low=0
        high=len(nums)-1
        
        while(low<=high):
            mid=(low+high)//2
            # FOund Target
            if nums[mid]==target:
                return mid
            # I fthe right side of the array is sorted
            elif nums[low]<=nums[mid]:
                if (nums[low]<=target <= nums[mid]):
                    high=mid-1
                else:
                    low=mid+1
            # left side is sorted
            else:
                if nums[mid]<= target <=nums[high]:
                    low=mid+1
                else:
                    high=mid-1
        return -1
