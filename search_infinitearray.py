"""
time complexity: O(logN) - N is the size of the array
space complexity:O(1) - no extra space is used

doubt - why are we using reader.get(mid) instead of reader[mid]

Explination: intitalising the low and the high with 0 and 1 and checking if the target is less than then high
else keep on increasing the range of high and make the high as low and carry out a binary search between low and high
"""


class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        low=0
        high=1
        while(reader.get(high)<target):
            low=high
            high=high*2
        return self.binarysearch(low,high,reader,target)
    def binarysearch(self,low,high,reader,target):
        while(low<=high):
            mid=(low+high)//2
            if reader.get(mid)==target:
                return (mid)
                return mid
            elif reader.get(mid)>target:
                high=mid-1
            else:
                low=mid+1
        return -1