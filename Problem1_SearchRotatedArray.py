'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

#-------------  
# Explanation:
#-------------
# Find pivot element (element at index i which is > than element at i+1)
# Divide the input array along the pivot to get two sorted arrays.
# Check if target item is >= the first item in the first sorted array. 
# If target item >= first element of LHS it should be in the LHS of pivot 
#- use binary search on LHS of pivot (including pivot)
# Else search target in RHS of pivot. If target is lower than the lowest 
# element on LHS of pivot, then it should on RHS of pivot (excluding pivot)

#-----------------
# Time Complexity: 
#-----------------
# O(log(N)) - Binary search on M*N elements
#------------------
# Space Complexity: 
#------------------
# O(1) - Only using constant space to store index values and lengths


#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes
# Time             :  32-40 ms  (45 - 97.42 %ile)
# Space            :  14.7MB (52.7 %ile)

from typing import List

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums)-1

        pivot_index = self.find_pivot(nums, 0, len(nums)-1)
        if pivot_index == -1:
            return self.binary_search(nums, low, high, target)


        if nums[pivot_index] == target:
            return pivot_index

        if nums[low] <= target:
            return self.binary_search(nums, low, pivot_index, target)

            
        return self.binary_search(nums, pivot_index+1, high, target)
        # print(f"pivot_index: {pivot_index}")
        # print(f"nums:{nums}, target:{target}")
    
    def find_pivot(self, pivot_arr: List[int], low:int, high:int):
        if low >= high:
            #Coun't find pivot. Sorted array without rotation
            return -1
        
        else:
            mid = (low + high)//2
            # print(f"pivot_arr: {pivot_arr}, \
            #     low:{low}, high:{high}, mid:{mid}")
            
            if (pivot_arr[mid] > pivot_arr[mid+1]):
                return mid
            
            else:
                if (pivot_arr[mid-1] > pivot_arr[mid]):
                    return (mid-1)

                elif pivot_arr[low] >= pivot_arr[mid]:
                    return self.find_pivot(pivot_arr, low, mid-1)

                else:
                    return self.find_pivot(pivot_arr, mid+1, high)

    def binary_search(self, nums:List[int], low:int, high:int, target:int):
        while low <= high:
            mid = (low + high)//2
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                low = mid+1
            else:
                high = mid-1

        return -1


obj = Solution()
print(f"=={obj.search([7,1,3,3], 1)}==")
