# Time complexity O(log(n)) -- n is length of the range where target exists
def searchNum(arr, target):
    low = 0
    high = 2
    while(low <= high):
        mid = low + (high - low) // 2
        if arr[low] <= target and arr[high] >= target:
            if arr[mid] == target:
                return mid
            if arr[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        else:
            low = high
            high = high * 2
    return -1

x = searchNum([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29], 10)
print(x)