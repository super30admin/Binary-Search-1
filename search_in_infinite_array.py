"""
Author: Srinidhi Bhat 
Did the Code run: Yes. This question is not on leetcode, but it works

Time Complexity: O(log N) here N is the position at which high(last index) was visited.
Space Complexity: O(1) - no additional space except for variables

Logic: Since it sorted -- binary search
But we do not know the last index, so we have to find in between which indexes to search
in this binary search. 
To find high, we just try to check where the arr[high] > key, that will be the upper bound. 
"""
def binarySearch(arr,low,high,key):
    while low <= high:
        mid = low + (high-low)//2
        if arr[mid] == key:
            return mid
        else:
            if arr[mid] > key:
                high = mid - 1
            else:
                low = mid + 1
    return -1

#Method to find between which two indexes to apply binary search
#Since the array is infinite, we just have to find between which two indexes to search
#logic is to find the high, compare the current index value and the key
#If the current val > key, then we know the two indexes where to search in between
def findIndex(arr,key):
    low,high = 0,1
    val = arr[low]

    while val < key:
        low = high #the previous high is not the new low, since the val doesnt lie in the current [l,h]
        high = 2*high
        val = arr[high]
    
    return binarySearch(arr,low,high,key)

arr = [1,11,21,31,41,51,111,122,123,1445,14478,14445789]
key = 123
ans = findIndex(arr,key)

if ans ==-1:
    print("Not there in array")

else:
    print("The position is",ans)