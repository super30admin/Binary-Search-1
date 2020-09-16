#Time Complexity: O(log n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums)-1
        
        while left <= right:
            mid = left + (right - left) // 2                        #Used to prevent memory overflow
            if nums[mid] == target:                                 #return mid as that is the index of the target
                return mid
            elif nums[mid] >= nums[left]:                           #Checking if there is a pivot from starting of the array to mid, goes in if there is no pivot in between
                if nums[mid] > target and nums[left] <= target:     #Checking if there is target in between the start and mid of the array
                    right = mid - 1                                 #Change the end to mid - 1 as the target is on the left
                else:
                    left = mid + 1                                  #change the start to mid + 1 if the target is in the right
            else:                                                   #Goes in here if the pivot is in between left and mid
                if nums[mid] < target and nums[right] >= target:    #Checks if the target is in the right of mid
                    left = mid + 1
                else:
                    right = mid - 1
        return -1
