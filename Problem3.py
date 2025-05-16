# https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
# // Time Complexity :O(logn)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode : 
# // Any problem you faced while coding this :No


# Finding range in which our target , then doing Binary Search

def bs(nums,target,l,h):
  # l,h=0,len(nums)-1
  while(l<=h):
    mid=l + (h-l)//2
    if nums[mid]==target:return mid
    elif nums[mid]>target:h=mid-1
    else: l=mid+1
  return -1


def ran(list,target):
  #here list is inf list, size is unknown
  l,h=0,1
  notinRange=True
  while(notinRange):
    if target<h:
      l=h
      h=2*h
    else: notinRange= False
  return bs(list,target,l,h)
  
  
      
