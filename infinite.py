#Search in Infinite sorted array

class Solution(object):
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        l,h = 0,1
        while reader.get(h)<target:
            l = h
            h = h*2 # Exponentially increase the search range until we find a value greater than or equal to target or the max index
        #Binary search in the range
        while l<=h:
            mid = (l+h)//2
            val = reader.get(mid)
            if val==target:
                return mid
            elif val<target:
                l = mid+1
            else:
                h = mid-1
        return -1

        