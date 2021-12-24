# time complexity O(log n)
# avg space complexity O(1)
from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        start = 0 
        end = len(nums) -1
        while start <= end :
            mid = start + (end - start)//2
            if nums[mid] == target:
                return mid
            if (nums[start] <= nums[mid]): # the left side is sorted
                if target <= nums[mid] and target >= nums[start]: # target is present in this half
                    end = mid -1
                else: # target might be present in other half 
                    start = mid + 1
            else: # if right side is sorted
                if target >= nums[mid] and target <= nums[end]: # target is present in this half
                    start = mid + 1 
                else:
                    end = mid - 1          
        return -1









# class Solution:
#     def search(self, nums: List[int], target: int) -> int:
#         if len(nums) <= 3:
#             return nums.index(target) if target in nums else -1
        
#         def find_pivot(arr):
#             for i in range(len(arr) -1):
#                 if arr[i] > arr[i+1]:
#                     return i
#                     break
#             return -1
        
#         pivot = find_pivot(nums)
        
#         def find_element(arr, start, end):
            
#             if start <= end:
#                 mid = (start+end) // 2
#                 if arr[mid] == target:
#                     return mid
#                 elif arr[mid] < target:
#                     return find_element(arr, mid+1, end)
#                 elif arr[mid] > target:
#                     return find_element(arr, start, mid - 1)
#             else:
#                 return -1
        
#         res_1 = find_element( nums, 0, pivot)
#         res_2 = find_element( nums, pivot+1, len(nums)-1)
        
#         print(pivot)
#         print(res_1)
#         print(res_2)
#         if res_1 != -1:
#             return res_1
#         else:
#             return res_2
        