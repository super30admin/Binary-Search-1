'''
Time Complexity : O(log n)

Space Complexity : O(1)

Did this code successfully run on Leetcode : Yes

Any problem you faced while coding this : None

Explanation: Find the height by intialising the low = 0 and high =1
Increase high by 2 and set low to previous value of high until high<target.
Perform Binary search as normal.
Added out of bounds exception as well.
'''

def binarySearch(arr, l, r, x):

    if l <= r:
        mid = int (l + (r-l) / 2)
        if arr[mid] == x:
            return mid
        elif arr[mid] < x:
            l = mid + 1
            return binarySearch(arr,l,r,x)
        else:
            r = mid - 1
            return binarySearch(arr, l, r, x)

    return -1

def search(arr, x):
    try:
        low = 0
        high  = 1
        val = arr[0]

        while arr[high] < x:
            low = high
            high = 2 * high

    except Exception:
        print("Error: Out of Bounds Exception!")
        return -1

    return binarySearch(arr, low, high, x)

# Test array
arr = [1,4,5,6,7,9,10,34,65,78,99,103,340,569,655,898,901,1023,2340,5606]
x = 99

# Function call
result = search(arr, x)

if result != -1:
    print("Element is present at index " +str(result))
else:
    print("Element is not present in array")
