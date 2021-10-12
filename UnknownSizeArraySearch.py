# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
        
  def search(self, reader, target):
    """
    :type reader: ArrayReader
    :type target: int
    :rtype: int
    """
    i = 2
    left = 0
    right = 0
    
    while reader.get(i) < target:
      left = i
      i*=2
    
    right = i
    
    while left <= right:
      mid = int((left + right)/2)
      if reader.get(mid) == target:
        return mid
      elif reader.get(mid) < target:
        left = mid + 1
      else:
        right = mid - 1
    return -1
