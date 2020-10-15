# Here in this problem, the lenght of array is unknown, linear search will take O(n) time, but as the array is sorted, I tried to use binary search to solve it in log (n) time.
# Time Complexiity: O(log(n))
# Space Complexity: O(n) 
def binarySearch(arr, low, high, target): 
    while(low<=high):
        mid = int((low+high)/2)
        if (arr[mid]==target):
            return mid
        elif (target>arr[mid]):
            low = mid + 1
        else:
            high = mid - 1
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
