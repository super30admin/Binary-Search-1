# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

# Approach - In order to conduct a binary search on sorted data where the search range is unknown, we first need to determine the appropriate range. To find this range, we double its size every time we realize we haven't encompassed the target element. Once the suitable range is identified, we can then proceed with the standard binary search procedure. 

# Time complexity  -  To find the range O(log(m)) and to find the target element using bs is O(log(n)) =  O(log(m))+O(log(n))

# Space complexity - constant space usage

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        #binary search to look for the target
        def bs(lo,hi):
            while lo<=hi:
                mid = (lo+hi)//2
                if reader.get(mid)==target:
                    return mid
                elif reader.get(mid)<target:
                    lo=mid+1
                elif reader.get(mid)>target:
                    hi=mid-1
            return -1
        #Find the range by doubling process if we have not found the right range   
        l=0
        h=l+1
        while (reader.get(h)<target):
            l=h
            h=l*2
        ans=bs(l,h)
        return ans