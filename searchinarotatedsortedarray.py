# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def search(self, nums: List[int], target: int) -> int:

        start=0
        end=len(nums)-1
        
        while(start<=end):
            mid=start+(end-start)//2
            
            if nums[mid]==target:
                return mid
            
            elif nums[mid]<nums[end]:
                
                if nums[mid]<target and nums[end]>target:
                    start=mid+1
                else:
                    end=mid-1
            else:
                
                if nums[start]<target and nums[mid]>target:
                    end=mid-1
                else:
                    start=mid+1
        return -1
        

# Check for the mid first, then see if the  end is greater than mid, then consider that set if not consider the array from start to mid. see if the target is in the range of the sorted array,
#  if yes then perform bst, else consider the other part. Look for the deterministic part (Sorted Part) and intially look for the target in that range else move to the undetermistic part and look for it.