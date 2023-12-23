# TC - O(logn)
# SC - O(1)
# Here the array is rotated, so atleast half of the array is sorted, how do we know if an array is sorted, as low<mid if arr[low]<arr[mid]. If [low, mid] range is sorted and if target exists in the range, then make high as mid-1. if target does not exist then low = mid+1. And viceversa for the other range [mid, high]. 
# I made a mistake in the condition, arr[low]<arr[mid]. If we dont include <= condition, if low = 6, mid = 6, we will not be able to update them, hence, we will not be able to break out of the loop.
# 4 5 6 7 0 1 2
# target --> 0
# lo = 0, hi = 6, mid = 3
# lo = 4, hi = 6, mid = 5 --> arr[mid] 
# lo = 4, hi = 4, mid = 4 --> return 4

# target --> 3
# lo = 4, hi = 6, mid = 5 --> 
class Solution:
    def search(self, arr: List[int], target: int) -> int:
        lo, hi = 0, len(arr)-1
        while lo <= hi:
            mid = (lo+hi)//2
            if target == arr[mid]:
                return mid
            if arr[lo] <= arr[mid]:
                if target >= arr[lo] and target < arr[mid]:
                    hi = mid-1
                else:
                    lo = mid+1
            elif arr[mid] <= arr[hi]:
                if target > arr[mid] and target <= arr[hi]:
                    lo = mid+1
                else:
                    hi = mid-1
        return -1        