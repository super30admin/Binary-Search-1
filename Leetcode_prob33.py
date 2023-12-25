#time complexity: O(logn)
#space complexity: O(1)

class Solution:
    def search(self, arr, target):
        if not arr or len(arr) == 0:
            return -1

        low, high = 0, len(arr) - 1

        while low <= high:
            mid = low + (high - low) // 2

            if arr[mid] == target:
                return mid
            elif arr[low] <= arr[mid]:
                if arr[low] <= target < arr[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if arr[mid] < target <= arr[high]:
                    low = mid + 1
                else:
                    high = mid - 1

        return -1
