// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        start,end=0,10001
        while(start<=end):
            mid=(start+end)//2
            val=reader.get(mid)
            if val==target:
                return mid
            elif val<target:
                start=mid+1
            elif val==2147483647 or val>target:
                end=mid-1
        return -1