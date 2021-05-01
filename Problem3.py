

def findtarget(arrayreader,target,arr):
    low = 0
    high = len(arr)-1
    while(target>arrayreader[high]):
        low = high
        high = 2*high
    index = binarysearch(arr,low,high,target)
    return index

def binarysearch(arr,low,high,target):
    mid = low + (high-low)/2
    while(low<=high):
        if arr[mid]== target:
            return mid
        elif arr[mid]>target:
            high = mid-1
        else:
            low = mid+1
    return -1
