# Time Complexity : O(logn)
# Space Complexity : O(logn)
# Did this code successfully run on Leetcode : It's in premium so couldn't test it on leetcode,worked for my own testcases
# Any problem you faced while coding this : No

def unlimitedList(arr,target):
    low = 0
    high = 1
    while True:
        if arr.get(high) < target:
            low = high
            high = high*2
        else:
            break
    return binarySearch(arr,low,high)

def binarySearch(arr,l,r,t):
    if l>r:
        return False
    mid = (l+r)//2
    if arr.get(mid) == t:
        return mid
    elif arr.get(mid) < t:
        return binarySearch(arr,mid+1,r,t)
    return binarySearch(arr,l,mid-1,t)

