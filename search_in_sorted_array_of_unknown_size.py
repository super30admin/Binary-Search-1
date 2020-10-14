# Time complexity:- O(log(n)) n=no. of elements in low-hi
# space complexity:- O(1)
# Did this code successfully run on Leetcode :Yes
# Idea:- AT first thought of using the constraint to define the hi but that would defy the problem statement
# So decided to start from 1 and increase hi just like in a Binary Search we divide by half, Thought of
# multiplying by 2. And continue doing this process only till we find that target is within this high boundary
# Once we find this hi boundary we can stop and do normal binary search
class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        low=0
        hi=1
        while(reader.get(hi)!=sys.maxsize):
            if target<reader.get(hi):
                break
            hi*=2
        while(low<=hi):
            mid=(low+hi)>>1
            if reader.get(mid)==target:
                return mid
            if target<reader.get(mid):
                hi=mid-1
            else:
                low=mid+1
        return -1