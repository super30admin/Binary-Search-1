# we define a right value which defines the boundary
# we increase right boundary by bit manipulation which 2^x
# once we get right(right) boundary [pun intended] is established , we binary search

class Solution :
  def search(self,reader,target):
    if reader.get(0) == target :
      return 0

    left,right = 0,1 

    while reader.get(right) < target :
      left = right
      right <<= 1

    while left <= right :
      pivot = left + right // 2
      mid = reader.get(pivot)

      if target == mid :
        return pivot
      if target > mid :
        left = pivot + 1
      if target < mid :
        right = pivot - 1

    
    return -1