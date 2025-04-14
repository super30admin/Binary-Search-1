#Time Complexity : O(logn)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 


# Your code here along with comments explaining your approach


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        low=0
        high=len(nums)-1
        
        while low<=high:
            
            mid=low+(high-low)//2
                        
            if nums[mid]==target:
                return mid
            # Left side of mid is sorted
            elif nums[mid]>=nums[low]:
                
                # if target present on left side
                if nums[mid]>target and nums[low]<=target:
                    high=mid-1
                # otherwise move to the right side of mid
                else:
                    low=mid+1
            # Right side of mid is sorted
            else:

            	# if target present on right side
                if nums[mid]<target and nums[high]>=target:
                    low=mid+1
                # otherwise move to the left side of mid
                else:
                    high=mid-1
        
        return -1
