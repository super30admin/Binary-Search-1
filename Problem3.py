# The array is sorted, so one could try to fit into a logarithmic time complexity.
#That means two subproblems, and both should be done in a logarithmic time:

#Define search limits, i.e. left and right boundaries for the search.
#Perform binary search in the defined boundaries.

#Time Complexity=O(logn)
#Space Complexity =o(1)
# Did this code successfully run on Leetcode : yes 
class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        if reader.get(0)==target:
            return 0
        
        left=0
        right=1
        while reader.get(right)<target:
            left=right
            right=right*2

        while left<right:
            mid=left+(right-left)//2
            num=reader.get(mid)

            if num==target:
                return mid
            if num>target:
                right=mid-1
            else:
                left=mid+1
        return -1