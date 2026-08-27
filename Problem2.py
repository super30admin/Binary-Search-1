
#Time Complexity : O(log(n))
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


#Your code here along with comments explaining your approach in three sentences only
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low, high = 0, len(nums) - 1
        
        while low<=high:
              mid = low + (high - low)//2

              if nums[mid] == target:
                 return mid
              
              if nums[low] <= nums[mid]:
                 if nums[low] <= target < nums[mid]:
                     high = mid
                 else:
                     low = mid + 1
              else:
                   if nums[mid] < target <= nums[high]:
                      low = mid + 1
                   else:
                        high = mid - 1
        return -1
