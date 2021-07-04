def findPosition(arr : [int], target : int):
    low = 0
    high = 1
    while arr[high] < target:
        low = high
        high = high * 2
    return binarySearch(arr, low, high, target)


def binarySearch(self, arr: [int], low, high, target : int):
    while low <= high:
        mid = low + (high - low) // 2
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            low = mid + 1
        else:
            high = mid - 1
    return -1

arr = [3, 5, 6, 7]
target = 5
print(findPosition(arr, target))
