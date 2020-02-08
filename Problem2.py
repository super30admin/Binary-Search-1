# Time Complexity : O(log n)
# Space Complexity :O(1)

class solution:
    def findPos(arr, target):
        low = 0
        high = 1
        # Doing Binary search in reverse manner, increase the search space between low and high where the target may exist
        while arr[high] < target:
            low = high
            high = 2 * high
        # After getting the search space, perform binary search
        while (low <= high):
            mid = (low + high) // 2
            if arr[mid] == target:
                return mid
            if arr[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        # return -1 if the target is not present
        return -1

    arr = [3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170]
    ans = findPos(arr, 10)
    if ans == -1:
        print("Element not found")
    else:
        print("Element found at index", ans)