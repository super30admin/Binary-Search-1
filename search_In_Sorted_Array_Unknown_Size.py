def binarySearch(arr, l, r, x): 
    while(l<=r):
        mid = int((l+r)/2)
        if (arr[mid]==x):
            return mid
        elif (x>arr[mid]):
            l = mid + 1
        else:
            r = mid - 1
    return -1

def searchArray(arr,target):
    if (len(arr)!=0 and target is not None):
        index = binarySearch(arr,0,len(arr),target)
        print("Element found at index: ",index)
    else:
        print("Array is empty or target is None hence  cannot search")

arr = [-1,0,3,5,9,12]
target = 9
searchArray(arr,target)