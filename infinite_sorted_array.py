

# // Time Complexity : # we will have O(n) complexity
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no
 
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        s=0
        e=1
            
        if reader.get(e)==target:
            return e
            #idea is to increase end by 2 until target becaome less than endand then apply binary search 
        while reader.get(e)<target:
            #if target is larger, then we can set start by e+1 and increament e to e+2
            s=e+1
            e=e+2
                
        while s <= e:
            mid=s+(e-s)//2
            
#  reader.get(i) that returns the value at the ith index
            if target==reader.get(mid):
                return mid
            elif target< reader.get(mid):
                #target is at left
                e=mid-1
            else:
                #target is at right
                s=mid+1
        return -1
                