"""
Time Complexity: O(log n)
Space complexity: O(n)
Did the problem run on Leetcode?: Problem not on leetcode

Problem:
Suppose you are given a sorted array of infinite length and a number to search for, return the index of the number.  
If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1. 
"""

def search(arr, target):
    l = 0               # starting low index
    h = 1               # starting high index
    val = arr[0]        # starting value
    
    # as long as the value at arr[h] is smaller than target
    # update l, h and val
    # when val > target, then surely my target is within the current low/hi range
    while val < target:
        l = h               # update l to h
        h = 2*h             # update h to twice that of current h
        val = arr[h]        # update val to element at h index
        
    # after the proper range is found, perform binary search
    while l <= h:
        mid = l + (h - l) // 2
        if arr[mid] == target:      # return mid index if target is found
            return mid
        elif target > arr[mid]:
            l = mid + 1
        else:
            h = mid - 1
    
    return -1           # if target is not found, then return -1

# Testing 
arr = [3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170] 
ans = search(arr,20)

if ans == -1:
    print("Element not found")
else:
    print("Element found")