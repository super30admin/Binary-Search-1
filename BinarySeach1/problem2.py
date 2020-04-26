#Time Complexity: O(logn)
#Space Complexity: O(1)
#Did this code successfully run on leetcode: yes
#Any problem you faced while coding thing:
def binary_search(arr,low,high,target):
  if high>=low:
    mid=low+(high-low)/2
    if arr[mid]==target:
      return mid
    if arr[mid]>target:
      return binary_search(array,low,mid-1,target)
    return binary_search(array,mid+1,mid-1,target)

def find_infinite(array,target):
  # we find in a log(n) speed an interval such that it contains the target
  # we want to make sure the interval is not too big either
  #Once we found the interval , we do normal binary search
  low=0
  high=1
  val=array[0]
  while val<target:
    low=high
    high=2*high
    val=array[high]
  return binary_search(array,low,high,target)
#while we cannot talk about real time complexity, we can consider it unknown rather than infinite
#and then how long it would take to reach the unknown
