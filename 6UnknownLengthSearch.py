"""
Not in LC
// Time Complexity :O(Log n) using Binary search
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :NA
// Any problem you faced while coding this :Failing for target=27
and greater values
"""

def BinarySearch(arr,target):
  l,h=0,1
  while(l<h):
    mid=int(l+(h-l)/2)
    print(l,h,mid)
    if arr[h]<target:
      l=h
      h=l*2
    elif arr[h]==target:
      return h

    if (len(arr)==0 or arr is None):
      return -1
    if arr[mid]==target:
      return mid
    elif target<arr[mid]:
      h=mid-1
    else:
      l=mid+1
  return -1


arr=[1,3,6,9,12,15,18,21,24,27,30,33]
target=15

print("Idx=",BinarySearch(arr,target))
