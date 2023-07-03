class Solution:
    def search(self, arr, target):
        if arr is None or len(arr) == 0:
            return -1
        low = 0
        high = len(arr) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if arr[mid] == target:
                return mid
            elif arr[low] <= arr[mid]:
                if arr[low] <= target and arr[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if arr[mid] < target and arr[high] >= target:
                    low = mid + 1
                else:
                    high = mid - 1
        return -1

# search method
arr = [4, 5, 6, 7, 0, 1, 2]
target = 6

sol = Solution()

# Call the search method and print the output
result = sol.search(arr, target)
print("Index of the target value:", result)
