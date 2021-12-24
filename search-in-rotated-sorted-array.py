class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        

#Optimized
        low = 0
        high = len(nums) - 1
        while (low <= high):
            mid = (low + high)//2
            if nums[mid] == target:
                return mid
            elif nums[mid] >= nums[low]: # Checking if its left sorted
                if nums[mid] > target and nums[low] <= target: # Checking if it lies in the sorted side
                    high = mid - 1
                else:
                    low = mid + 1
            else: # Checking if its right sorted
                if nums[mid] < target and nums[high] >= target: # Checking if it lies in the sorted side
                    low = mid + 1
                else:
                    high = mid - 1
        return -1

#BruteForce
#         def binarySearch(left, right):
#             while left <= right:
#                 mid = (left + right)//2
#                 if nums[mid] == target:
#                     return mid
#                 elif nums[mid] < target:
#                     left = mid + 1
#                 else:
#                     right = mid - 1

#             return -1

#         p1, p2, temp, size = 0, 1, -1, len(nums)
#         left, right = 0, size-1
#         while p2 <= size-1:
#             if nums[p1] > nums[p2]:
#                 temp = p2
#                 break
#             p1 = p2
#             p2 += 1
        
#         if temp == -1:
#             return binarySearch(left, right)
#         else:
#             if nums[temp] == target:
#                 return temp
#             elif nums[temp] < target and nums[right] >= target:
#                 left = temp + 1
#             else:
#                 right = temp - 1
#             return binarySearch(left, right)



