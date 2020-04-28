def find(arr: [], size: int):
    low = 0
    high = size - 1
    while high > low + 1:
        mid = (low + high) // 2
        if (arr[low] - low) != (arr[mid] - mid):
            high = mid
        elif (arr[high] - high) != (arr[mid] - mid):
            low = mid
        else:
            return None
    return arr[mid] + 1
    return -1


arr = [1, 3, 4, 5, 6, 7, 8]
size = len(arr)
print("Missing value is:", find(arr, size))
