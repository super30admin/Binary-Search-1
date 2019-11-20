# Binary search is not working properly, but the indexes from helper function returned are correct
# runtime-- O(logn)  memory--

#binary search 
def binary_search (arr, l, r, x): 
    if r >= l: 
        mid = l + (r - l)/2
        if arr[mid] == x: 
            return mid 
        elif arr[mid] > x: 
            return binarySearch(arr, l, mid-1, x) 
        elif arr[mid]<x:
            return binarySearch(arr, mid + 1, r, x) 
        else:
            return -1
    return -1

'''
main idea

To start two pointers first ans second from first and second index of list

Checking if target value is present between 2^n indexes. Which means checking for array values at 0 th, 2 nd, 4 th, 8 th so on 
positions.

If value at any position is greater than target [lets say 2^4 = 16 th position].
Retain the index value and do binary search between 2^(4-1) and 2^(4) to return index.

I have saved the last value in a variable and returned both from helper function

'''
def helper(nums,target,first,second):
    a = [None]*2
    a[0] = second
    try:
        while(nums[second]<=target):
            first = second
            second = second*2
            a[0] = a[1]
            a[1] = second
        print("check between",a[0],"and ",a[1],"indexes")
        return a
    except:
        print("check between index",a[0]," and last index")
        return a[0]

#calls helper functin and performs binary search

def infinite(nums,target):
    a = helper(nums,target, 0, 1)
    try:
        print(binary_search(nums,target,a[0],a[1]))
    except TypeError:
        high = nums.index(nums[-1])
        print(binary_search(nums,target,a,high))
    pass

#creating a big array
nums = []
for i in range(1000000):
    if i%13==0:
        nums.append(i)
print("results for 507")
infinite(nums,507)
print()
print("results for 52")
infinite(nums,52)
