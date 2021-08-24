# Time complexity 

log(m) + log(n)

#  where m is number of steps and n is range

# Space complexity 

0(1)

# yes code worked succesfully on leetcode





class Solution(object):
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        low,high = 0,1
        
        while reader.get(high)<target:
            low = high
            high = high*2
            
        while low <= high:
            mid = low +(high-low)/2
            if reader.get(mid)== target :
                return mid
            elif reader.get(mid)>target:
                high = mid-1
            else:
                low = mid+1
        return -1
