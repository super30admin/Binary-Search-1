# -*- coding: utf-8 -*-
"""
Created on Sat Sep 19 12:48:33 2020
@author: Tripti Santani

        # Input: nums = [4,5,6,7,0,1,2], target = 0
        # Output: 4
        
        # Supposing length of input is N
        # Brute Force - Linear Search Time Complexity- O(N) Space Complexity - O(1)
        
        # Iterative approach (Binary Search)
        # Time Complexity: O(log N)
        # Space Complexity: O(1)
       
        Step1: Define start and end
        Step2: With condition that start <= end, start a while loop
        Step3: Find the middle element of the input list with index number defined as mid in the below code
        Step4: Check if the middle element is the target element. If yes, return mid i.e. index number of middle element
        Step5: Else check if the right side of the mid is sorted.
               If yes, check if the target lies from start as index number of the list till mid-1:
                             If yes then end = mid-1
                             Else it lies on the left side of the mid, then start = mid+1
        Step6: Else left side of the mid is sorted :
                 Check if the target is in between mid+1 till end. If yes, start = mid+1
                       else end = mid-1
        Step7: Return -1 When we are out of loop and still we did not encounter the target, means it is not present.
               In that case, we return -1
        
        # Code accepted in leetcode
        """

class Solution:
    def search(self, nums, target) -> int:
        
        # Edge case 
        if len(nums)==0 or nums is None:
            return -1
        
        start = 0
        end = len(nums)-1
        
        while (start<=end):
            # mid is the middle index of the list
            mid = int(start + (end-start)/2)
            
            # Middle element is target
            if nums[mid] == target:
                return mid
            
            # Left of the target is sorted
            elif nums[mid] >= nums[start]:
                if target >= nums[start] and target < nums[mid]:
                    end = mid-1
                else:
                    start = mid + 1
            
            # Right of the target is sorted 
            else:
                if target <= nums[end] and target > nums[mid]:
                    start = mid + 1
                else:
                    end = mid - 1
        return -1
                
''' Driver Code '''

print("\nSearch in Rotated Sorted Array\n")
binary_search = Solution()
nums = [4,5,6,7,0,1,2]
target1 = 0
target2 = 3
result1 = binary_search.search(nums,target1)
print("Target1 found at:" + str(result1))
result2 = binary_search.search(nums,target2)
print("Traget2 found at:"+str(result2))