'''
The search function implements a modified binary search algorithm to find 
the target element in the given nums list, which is sorted in ascending 
order with distinct values. It handles the case where the array is rotated 
at an unknown pivot index.

The function first checks if the nums list is empty or None, returning -1 
if so. Then it initializes pointers low and high for the binary search 
within the array.

The function uses a while loop to perform binary search and update the 
pointers low and high accordingly based on the sorted nature of the array 
and the target value. If the target is found, the function returns the 
index of the target; otherwise, it returns -1 to indicate that the target 
is not present in the nums list. The time complexity of the algorithm is 
O(log n).
'''


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if nums== None or len(nums)== 0:
            return -1

        n =len(nums)
        low =0
        high = n-1

        while low <= high:
            mid = low+ (high-low)//2 #prevent integer overflow
            if nums[mid] == target :
                return mid
            if nums[low] <= nums[mid]:
                if target >= nums[low] and target < nums[mid]:
                    high = mid-1
                else:
                    low =mid+1

            else:
                if target > nums[mid] and target <= nums[high]:
                    low= mid+1
                else:
                    high = mid -1
        return -1
