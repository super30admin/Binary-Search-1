# Time Complexity: O(log(10^4))
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
# Class ArrayReader:
#   def get(self, index: int) -> int:

class Solution:
  def search(self, reader, target):
    i = bisect.bisect_left(range(10**4), target, key = lambda m: reader.get(m))
    return i if reader.get(i) == target else -1