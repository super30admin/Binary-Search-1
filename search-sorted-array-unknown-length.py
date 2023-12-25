def binary_search(arr, target, low, high):
    while low <= high:
        mid = (low + high) // 2
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            low = mid + 1
        else:
            high = mid - 1
    return -1  # Target not found

def search_unknown_length(arr, target):
    # Exponential search to find the range
    index = 1
    while index < len(arr) and arr[index] < target:
        index = index * 2

    # Apply binary search within the found range
    return binary_search(arr, target, index // 2, min(index, len(arr) - 1))