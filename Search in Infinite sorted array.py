def sortedArrLength(arr, key):

    l, h, val = 0, 1, arr[0]

    # Finding the length of Sorted Array
    while val < key:
        l = h
        h = h*2
        val = arr[h]

    return binarySearch(arr, l, h, key)
    
    
def binarySearch(arr, l, r, target):
    
    if r >= l:
        mid = (l + r) //2

        if arr[mid] == target:
            return mid

        if arr[mid] >= target:
            r = mid - 1
            return binarySearch(arr, l, r, target)
        
        else:
            l = mid + 1
            return binarySearch(arr, l, r, target)
    
    return -1




    

    

