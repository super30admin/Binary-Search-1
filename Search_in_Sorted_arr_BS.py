// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach: using binary search high, mid and low. dont know about the exceptions. tried it on a compiler.


def BinarySearch(arr, target):
    low = 0
    high = len(arr)-1
    mid = (low+high)//2

    while low<high:
      if arr[low] == target:
        return low
      if arr[high] == target:
        return high
      if target>arr[low] and target<=arr[mid]:
        low = low + 1
        high = mid
      if target<arr[high] and target>=arr[mid]:
        high = high - 1
        low = mid
    
    return -1


arr = [0,1,3,4,5,5,6,8,9]
target = 4
print(BinarySearch(arr, target))
