# Time Complexity : O(log(n))
# Space Complexity :O(1)
# Leet Code: Yes

def binarySearch(arr, l, r, t):
    while l <= r:
        mid = (l+r)//2
        if t == arr[mid]:
            return mid
        elif t > arr[mid]:
            l = mid+1
        else:
            r = mid-1

def infiniteSearch(arr, target):
    l = 0
    h = 1
    val = arr[0]

    while val < target:
        l = h
        h = 2*h
        val = arr[h]
    return binarySearch(arr, l, h, target)

# arr = [3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170]
# print(infiniteSearch(arr,10))
