'''
Time Complexity: O(logn)
Space Complexity: O(1)
'''
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        temp = nums
        low = 0
        high = len(temp)-1
        index = 999
        while(low<=high):
            mid = (low+high)//2
            if(nums[mid]==target):
                return mid
            elif(nums[mid]>=nums[low]):
                if(target>=nums[low] and target<nums[mid]):
                    high = mid-1
                else:
                    low = mid+1
            else:
                if(target>nums[mid] and target<=nums[high]):
                    low = mid+1
                else:
                    high = mid-1
        return -1
        
        