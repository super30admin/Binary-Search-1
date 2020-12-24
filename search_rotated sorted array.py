def binarySearch(arr, l, r, target):
    if r >= l:
        mid = (l+r) // 2
        if arr[mid] == target:
            return mid
        if arr[l] <= arr[mid]: # left is sorted
            if arr[mid] < target or arr[l] > target:
                return binarySearch(arr, mid+1, r, target)
            else:
                return binarySearch(arr, l, mid-1, target)
        else: # right is sorted
            if arr[mid] > target or arr[r] < target:
                return binarySearch(arr, l, mid-1, target)
            else:
                return binarySearch(arr, mid+1, r, target)
    else:
         return -1

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        return binarySearch(nums, 0, len(nums)-1, target)
