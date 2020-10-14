class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        if reader.get(0)==target:
            return 0
        #since we do not know the bounds let us start with sub-array size of two and then increase exponentially
        #untill arr[end]<target

        start=0;end=1
        while reader.get(end)<target:
            start = end+1
            end += (end-start+1)*2 #so sub-array size increases in powers of 2

        #once you find array bounds call binary search
        return self.binary_search(reader,start,end,target)

    def binary_search(self,reader,start,end,target):

        while start<=end:
            mid = (start+end)//2
            if target==reader.get(mid):
                return mid

            if target<reader.get(mid):
                end=mid-1
            elif target>reader.get(mid):
                start=mid+1

        return -1
