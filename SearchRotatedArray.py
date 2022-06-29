# Time Complexity : 42
#  Space Complexity : 14.2
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : N/A

#  Your code here along with comments explaining your approach
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) - 1
        
        #Do binary serach to acquire the desired index
        while (left<= right):
            mid = (left + right) // 2
            
            #If we find mid as target return mid
            if nums[mid] == target:
                return mid
        
            #Serach the first halve of the array
            elif nums[left] <= nums[mid]:
                #if target is in between mid and greater then left set the upper bound to mid - 1 else change the lower bound
                if target>= nums[left] and target <= nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            #If the raget in in-between mid and right then change 
            else:
                if target >= nums[mid] and target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1
        return -1