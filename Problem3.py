# Time Complexity : O(logn base 100) + O(100)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : It's in premium so couldn't test it on leetcode,worked for my own testcases
# Any problem you faced while coding this : No

def unlimitedList(arr,target):
    jump = 100
    start = 0
    exist = False
    while True:
        try:
            if arr[start+jump] == target:
                return start+jump
            elif arr[start+jump] < target:
                start = start + jump
            else:
                exist = True
                break

        except:
            exist = False
            break
    if exist:
        return binarySearch(arr,start,start+jump,target)
    else:
        end = findLength(arr,start,start+jump)
        return binarySearch(arr,start,end,target)

def binarySearch(arr,l,r,t):
    if l>r:
        return False
    mid = (l+r)//2
    if arr[mid] == t:
        return mid
    elif arr[mid] < t:
        return binarySearch(arr,mid+1,r,t)
    return binarySearch(arr,l,mid-1,t)

def findLength(arr,start,end):
    start = start + 1
    while start <= end:
        try:
            a = arr[start]
            start = start + 1
        except:
            return start
    return end

