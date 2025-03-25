#Search in Infinite sorted array#
#Search in a Sorted Array of Unknown Size#

#from the question the max number is 1000 and we use get  ethod which can handle exceptions easily.
# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader(object):
#    def get(self, index):
#        """
#        :type index: int
#        :rtype int
#        """

class Solution(object):
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        l, r = 0, 10000
        while l <= r:
            mid = (l+r)//2
            val = reader.get(mid)
            if val == target: return mid
            elif val < target: l = mid+1
            else: r = mid-1 
        return -1