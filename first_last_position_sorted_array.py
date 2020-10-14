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
    startIndex = -1
    endIndex = -1
    idxList = list()
    idxList = [startIndex,endIndex]
    if (len(arr)!=0 and target is not None):
        startIndex = binarySearch(arr,0,len(arr),target)
        print("Element start index: ",startIndex)
        idxList[0] = startIndex
        for i in range(startIndex,len(arr)):
            if (arr[i] != target):
                endIndex = i-1
                break
        idxList[1] = endIndex
        print("End index is: ", endIndex)
        return idxList
    else:
        print("Array is empty or target is None hence  cannot search")

arr = [5,7,7,8,8,10]
target = 8
idx = searchArray(arr,target)
print("List of Indices:",idx)