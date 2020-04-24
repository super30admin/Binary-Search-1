"""
LC:33
// Time Complexity :T=O(log n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :No
// Any problem you faced while coding this:NA
"""
def bs(arr,t,l,r):
  mid = int((l+r)/2)
  target = t
  #print(l,r,mid)

  # target not present.
  if l > r:
    return -1

  # mid value target
  if target == arr[mid]:
    return mid

  # Left sorted
  if arr[l] < arr[mid]:
    if (arr[l] <= t and arr[mid] >= t):
      return bs(arr,t,l,mid)
    else:
      # target not in left sorted,check right array
      return bs(arr,t,mid+1,r)
  #Right sorted.
  else:
     if (arr[l] <= t and arr[mid] >= t):
       return bs(arr,t,l,mid-1)
     else:
       # target not in right sorted,check left array
       return bs(arr,t,mid+1,r)


if __name__ == "__main__":
  arr=[4,5,6,7,0,1,2]

  print("0",bs(arr,t=0,l=0,r=len(arr)-1))

  print("3",bs(arr,3,l=0,r=len(arr)-1))
